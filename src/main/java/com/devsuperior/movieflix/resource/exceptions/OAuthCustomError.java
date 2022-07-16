package com.devsuperior.movieflix.resource.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class OAuthCustomError implements Serializable {
    private static final long serialVersionUID = 1L;

    private String error;

    //Neste atributo foi mantido o camelcase próprio do JAVA, e utilizado o Jackson para formatar para JSON
    @JsonProperty("error_description")
    private String errorDescription;

    public OAuthCustomError() { }

    public OAuthCustomError(String error, String errorDescription) {
        this.error = error;
        this.errorDescription = errorDescription;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
