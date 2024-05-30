package com.idat.semana2.exceptions;

import com.idat.semana2.exceptions.model.UserNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ModelAndView handleUserNotFoundException(UserNotFoundException ex) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", ex.getMessage());
        mav.setViewName("error");
        return mav;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNotFoundError(NoHandlerFoundException ex, Model model) {
        model.addAttribute("errorMessage", "404 - Page Not Found");
        return "error";
    }

}
