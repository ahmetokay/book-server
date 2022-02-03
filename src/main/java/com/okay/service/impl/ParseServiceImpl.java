package com.okay.service.impl;

import com.okay.core.BaseException;
import com.okay.model.BookDto;
import com.okay.service.BookService;
import com.okay.service.ParseService;
import com.okay.util.BookUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ParseServiceImpl implements ParseService {

    private final BookService bookService;

    public ParseServiceImpl(BookService bookService) {
        this.bookService = bookService;
    }

    private List<String> urlList = Arrays.asList("https://www.kitapyurdu.com/kitap/wallace-deen-muhammed-amp-siyah-musluman-lider/601539.html&path=1_1033"
            , "https://www.kitapyurdu.com/kitap/kayip-tanrilar-ulkesi/583214.html&path=1_128"
            , "https://www.kitapyurdu.com/kitap/siyasi-muhafazakarlik-ve-turkiye/603588.html&path=1_1033");

    @Override
    public List<BookDto> parsePage() throws BaseException {
        List<BookDto> bookList = new ArrayList<>();
        try {
            for (String url : urlList) {
                Document doc = Jsoup.connect(url).get();

                BookDto bookDto = BookUtils.parseBook(doc);
                bookList.add(bookDto);

                bookService.saveOrUpdate(bookDto);
            }
        } catch (IOException e) {
            throw new BaseException(e.getMessage(), e);
        } finally {
            return bookList;
        }
    }
}