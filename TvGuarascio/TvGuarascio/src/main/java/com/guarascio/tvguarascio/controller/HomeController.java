package com.guarascio.tvguarascio.controller;

import com.guarascio.tvguarascio.monitor.Monitor;
import com.guarascio.tvguarascio.monitor.MonitorUfficio;
import com.guarascio.tvguarascio.monitor.Televisore;
import com.guarascio.tvguarascio.monitor.canale.Canale;
import com.guarascio.tvguarascio.monitor.canale.EState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RestController
public class HomeController {

    @GetMapping("/tv")
    public ResponseEntity<Televisore> getTelevisore() {

        Televisore televisore =
                new Televisore("Nero", "LG", LocalTime.now(), new Canale("Italia 1", 6, EState.SELECTED));

        return new ResponseEntity<Televisore>(televisore, HttpStatus.OK);
    }

    @GetMapping("/monitor")
    public ResponseEntity<Monitor> getMonitor() {

        Monitor monitor =
                new Monitor("rosso", "Sharp");

        return new ResponseEntity<Monitor>(monitor, HttpStatus.OK);
    }

    @GetMapping("/monitoruff")
    public ResponseEntity<MonitorUfficio> getMonitorUff() {

        MonitorUfficio monitorUfficio =
                new MonitorUfficio("rosso", "asus");

        return new ResponseEntity<MonitorUfficio>(monitorUfficio, HttpStatus.OK);
    }

    @PostMapping("/postmonitoruff")
    public ResponseEntity<MonitorUfficio> createMonitorUff(@RequestBody MonitorUfficio monitorUfficio) {
        return new ResponseEntity<MonitorUfficio>(monitorUfficio, HttpStatus.CREATED);
    }

    @PutMapping("/monitor/{id}")
    public ResponseEntity <?> updateMonitor(@PathVariable ("id") long id_monitor, @RequestBody MonitorUfficio monitor) {
        MonitorUfficio monitorUfficio = new MonitorUfficio("Nero","Samsung");
        if(monitorUfficio.getId() == id_monitor)
            return new ResponseEntity<>(monitorUfficio, HttpStatus.CREATED);
        return new ResponseEntity<>(monitor,HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/monitor/{id}")
    public ResponseEntity<?> deleteMonitor (@PathVariable long id){
        System.out.println("Monitor: " + id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/canale")
    public ResponseEntity<?> updateCanale(@PathVariable ("numero") long numero_canale, @RequestBody Canale canale){
        Canale canale1 = new Canale("Italia1", 6, EState.SELECTED);
        if(canale1.getNumero() == numero_canale )
            return new ResponseEntity<>(canale,HttpStatus.CREATED);
        return new ResponseEntity<>(canale,HttpStatus.NO_CONTENT);
    }
    @GetMapping("/risintonizza")
    public ResponseEntity<?> risintonizzaCanali(){
        Televisore tv = new Televisore("Blu","Philips",LocalTime.now(),new Canale("Rai 3", 3, EState.SELECTED),new Canale("Rai 2", 2, EState.NOT_SELECTED));
        tv.risintonizza();
        return new ResponseEntity<>(tv,HttpStatus.OK);
    }
    @DeleteMapping("/rimuovicanale")
    public ResponseEntity<?> deletecanale (@PathVariable long numero){
        System.out.println("Canale " + numero);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
