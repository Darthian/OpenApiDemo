package com.company.TechnicalDemo.infrastructure.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResponseErrorHandler;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse httpResponse)
            throws IOException {
        return (httpResponse.getStatusCode().value() == HttpStatus.Series.CLIENT_ERROR.value() ||
                httpResponse.getStatusCode().value() == HttpStatus.Series.SERVER_ERROR.value());
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse)
            throws IOException {
        if (httpResponse.getStatusCode().value() == HttpStatus.Series.SERVER_ERROR.value()) {
            //Handle SERVER_ERROR
            throw new HttpClientErrorException(httpResponse.getStatusCode());
        } else if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
            //Handle CLIENT_ERROR
            throw new NotFoundException();
        }
    }
}
