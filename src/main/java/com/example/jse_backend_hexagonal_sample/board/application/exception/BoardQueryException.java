package com.example.jse_backend_hexagonal_sample.board.application.exception;

import com.example.jse_backend_hexagonal_sample.common.exeption.CustomException;
import com.example.jse_backend_hexagonal_sample.common.exeption.ErrorCode;

public class BoardQueryException extends CustomException {
    public BoardQueryException(ErrorCode errorCode) {
        super(errorCode);
    }

    public BoardQueryException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
