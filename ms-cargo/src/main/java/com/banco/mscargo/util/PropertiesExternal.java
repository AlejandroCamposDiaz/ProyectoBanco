package com.banco.mscargo.util;

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
    
    @Value("${codigo.error.cargo}")
    public String pCODIGO_ERROR_CARGO;
    
    @Value("${mensaje.error.cargo}")
    public String pMENSAJE_ERROR_CARGO;
}
