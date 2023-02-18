package com.guarascio.tvguarascio.monitor;

import java.util.Set;

public class MonitorUfficio extends Monitor {
    private Long id;
    private String color;
    private String model;

    // Constructor, getters and setters for color and model omitted for brevity

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Set<String> inputs;

    public MonitorUfficio() {

        super();
    }

    public MonitorUfficio(String colore, String marca) {

        setColore(colore);
        setMarca(marca);
    }

    public MonitorUfficio(String colore, String marca, Set<String> inputs) {
        this.inputs = inputs;

        setColore(colore);
        setMarca(marca);
        this.inputs = inputs;
    }

    public Set<String> getInputs() {
        return inputs;
    }

    public void setInputs(Set<String> inputs) {
        this.inputs = inputs;
    }

    public void addInput(String input)  {
        if (!inputs.contains(input)) {

            inputs.add(input);
        }  //ignore

    }
}
