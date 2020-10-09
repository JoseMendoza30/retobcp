package com.bcp.app.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.app.dto.RequestCambio;
import com.bcp.app.dto.ResponseCambio;
import com.bcp.app.entity.CambioMoneda;
import com.bcp.app.entity.Catalogo;
import com.bcp.app.service.TipoCambioService;

import rx.Single;


@RestController
public class AppApi {

	@Autowired
	private TipoCambioService tipoCambioService;
	
	@GetMapping(value = "/")
    public String inicio(){
        return "Hola boot";
    }
	
	@PostMapping(value = "/catalogo")
    public ResponseEntity<?> listaCatalogo(){		
        return ResponseEntity.ok().body(tipoCambioService.listaCatalogo());
    }
	
	@PostMapping(value = "/cambio")
    public ResponseEntity<?> cambioMoneda(@RequestBody RequestCambio request){
		
        return ResponseEntity.ok().body(tipoCambioService.cambioMonedaRx(request));
    }
	
	@PostMapping(value = "/cambiorx")
    public Single<?> cambioMonedaRx(@RequestBody RequestCambio request){
		
        return tipoCambioService.cambioMonedaRx(request);
    }
	
	@PostMapping(value = "/actualizocambio")
    public ResponseEntity<?> insertTipoCambio(@RequestBody CambioMoneda request){
		
        return ResponseEntity.ok().body(tipoCambioService.insertUpdateTipoCambio(request));
    }
	
	
}
