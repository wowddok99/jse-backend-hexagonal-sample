package com.example.jse_backend_hexagonal_sample.board.application.exception;

import com.example.jse_backend_hexagonal_sample.common.exeption.CustomException;
import com.example.jse_backend_hexagonal_sample.common.exeption.ErrorCode;

public class BoardCommandException extends CustomException {
    // (intellij) Ctrl + O
    // (eclipse or sts) Alt Shift S => generate constructors

    public BoardCommandException(ErrorCode errorCode) {
        super(errorCode);
    }

    public BoardCommandException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
