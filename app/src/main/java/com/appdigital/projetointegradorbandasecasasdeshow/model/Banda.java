package com.appdigital.projetointegradorbandasecasasdeshow.model;

/**
 * Created by TARDE on 12/04/2018.
 */

public class Banda {
    private String nomebd ;
    private String integrantesbd ;
    private String generobd ;
    private String precobd ;
    private String cargabd ;
    private String descrcaobd;
    private String emailbd;
    private String telefonebd ;
    private String cpfbd;
    private String tipo;

    public Banda(String nomebd, String integrantesbd, String generobd, String precobd, String cargabd, String descrcaobd, String emailbd, String telefonebd, String cpfbd, String statusbanda) {
        this.nomebd = nomebd;
        this.integrantesbd = integrantesbd;
        this.generobd = generobd;
        this.precobd = precobd;
        this.cargabd = cargabd;
        this.descrcaobd = descrcaobd;
        this.emailbd = emailbd;
        this.telefonebd = telefonebd;
        this.cpfbd = cpfbd;
        this.tipo = statusbanda;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomebd() {
        return nomebd;
    }

    public void setNomebd(String nomebd) {
        this.nomebd = nomebd;
    }

    public String getIntegrantesbd() {
        return integrantesbd;
    }

    public void setIntegrantesbd(String integrantesbd) {
        this.integrantesbd = integrantesbd;
    }

    public String getGenerobd() {
        return generobd;
    }

    public void setGenerobd(String generobd) {
        this.generobd = generobd;
    }

    public String getPrecobd() {
        return precobd;
    }

    public void setPrecobd(String precobd) {
        this.precobd = precobd;
    }

    public String getCargabd() {
        return cargabd;
    }

    public void setCargabd(String cargabd) {
        this.cargabd = cargabd;
    }

    public String getDescrcaobd() {
        return descrcaobd;
    }

    public void setDescrcaobd(String descrcaobd) {
        this.descrcaobd = descrcaobd;
    }

    public String getEmailbd() {
        return emailbd;
    }

    public void setEmailbd(String emailbd) {
        this.emailbd = emailbd;
    }

    public String getTelefonebd() {
        return telefonebd;
    }

    public void setTelefonebd(String telefonebd) {
        this.telefonebd = telefonebd;
    }

    public String getCpfbd() {
        return cpfbd;
    }

    public void setCpfbd(String cpfbd) {
        this.cpfbd = cpfbd;
    }
}



