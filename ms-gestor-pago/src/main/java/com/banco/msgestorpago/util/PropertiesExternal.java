package com.banco.msgestorpago.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class PropertiesExternal{

    @Value("${codigo.identificador.exito}")
    public int pCODIGO_IDENTIFICADRO_EXITO;  
    
    @Value("${codigo.respuesta.exito}")
    public String pCODIGO_RESPUESTA_EXITO;
    
    @Value("${mensaje.respuesta.exito}")
    public String pMENSAJE_RESPUESTA_EXITO;
    
    @Value("${codigo.respuesta.error}")
    public String pCODIGO_RESPUESTA_ERROR;
    
    @Value("${mensaje.respuesta.error}")
    public String pMENSAJE_RESPUESTA_ERROR;
    
    
    @Value("${codigo.error.abono}")
    public String pCODIGO_ERROR_ABONO;
    
    @Value("${mensaje.error.abono}")
    public String pMENSAJE_ERROR_ABONO;    
    
    @Value("${codigo.exito.abono}")
    public String pCODIGO_EXITO_ABONO;
    
    @Value("${mensaje.exito.abono}")
    public String pMENSAJE_EXITO_ABONO;
    
    
    @Value("${codigo.error.cargo}")
    public String pCODIGO_ERROR_CARGO;
    
    @Value("${mensaje.error.cargo}")
    public String pMENSAJE_ERROR_CARGO;
    
    @Value("${codigo.exito.cargo}")
    public String pCODIGO_EXITO_CARGO;
    
    @Value("${mensaje.exito.cargo}")
    public String pMENSAJE_EXITO_CARGO;
    
    
    @Value("${codigo.error.recarga}")
    public String pCODIGO_ERROR_RECARGO;
    
    @Value("${mensaje.error.recarga}")
    public String pMENSAJE_ERROR_RECARGO;
    
    @Value("${codigo.exito.recarga}")
    public String pCODIGO_EXITO_RECARGO;
    
    @Value("${mensaje.exito.recarga}")
    public String pMENSAJE_EXITO_RECARGO;
}
