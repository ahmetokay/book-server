package com.okay.service;

import com.okay.core.BaseException;
import com.okay.model.BookDto;

import java.util.List;

public interface ParseService {

    List<BookDto> parsePage() throws BaseException;
}