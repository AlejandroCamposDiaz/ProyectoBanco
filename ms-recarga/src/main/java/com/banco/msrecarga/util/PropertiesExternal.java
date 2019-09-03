package com.banco.msrecarga.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class PropertiesExternal{

    @Value("${codigo.respuesta.exito}")
    public String pCODIGO_RESPUESTA_EXITO;
    
    @Value("${mensaje.respuesta.exito}")
    public String pMENSAJE_RESPUESTA_EXITO;
    
    @Value("${codigo.identificador.exito}")
    public int pCODIGO_IDENTIFICADRO_EXITO;
    
    @Value("${codigo.error.recarga}")
    public String pCODIGO_ERROR_RECARGO;
    
    @Value("${mensaje.error.recarga}")
    public String pMENSAJE_ERROR_RECARGO;
}
