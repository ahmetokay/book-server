package com.okay.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.okay.model.*;
import org.jsoup.nodes.Document;

import java.util.Arrays;

public class BookUtils {

    private static ObjectMapper mapper;

    private static ObjectMapper getMapper() {
        if (mapper == null) {
            mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        }
        return mapper;
    }

    public static BookDto parseBook(Document bookDocument) throws JsonProcessingException {
        String bookJsonData = bookDocument.select("div script[type$=application/ld+json]").html();

        // json içeriği update ediliyor
        bookJsonData = replateJson(bookJsonData);

        ParsedBookDto parsedBook = getMapper().readValue(bookJsonData, ParsedBookDto.class);

        return convertBook(parsedBook);
    }

    private static BookDto convertBook(ParsedBookDto parsedBook) {
        BookDto.BookDtoBuilder builder = BookDto.builder();
        builder.name(parsedBook.getName())
                .description(parsedBook.getDescription())
                .isbn(parsedBook.getIsbn())
                .imageUrl(parsedBook.getImage());

        ParsedAuthorDto author = parsedBook.getAuthor();
        if (author != null) {
            builder.authorList(Arrays.asList(AuthorDto.builder().name(author.getName()).build()));
        }

        ParsedPublisherDto publisher = parsedBook.getPublisher();
        if (publisher != null) {
            builder.publisher(PublisherDto.builder().name(publisher.getName()).build());
        }

        return builder.build();
    }

    private static String replateJson(String data) {
        data = data.replaceAll("&rsquo;", "'");
        data = data.replaceAll("&#039;", "'");
        data = data.replaceAll("&uuml;", "ü");
        data = data.replaceAll("&ouml;", "ö");
        data = data.replaceAll("&ccedil;", "ç");
        data = data.replaceAll("&Uuml;", "Ü");
        data = data.replaceAll("&ldquo;", "“");
        data = data.replaceAll("&rdquo;", "”");
        data = data.replaceAll("&hellip;", "...");
        return data;
    }
}