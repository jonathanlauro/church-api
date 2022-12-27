package br.com.churchapi.v1.api.models;

import java.util.List;

public class IgrejaComMembrosModel {
    private IgrejaModel igreja;
    private List<MembroModel> membroModels;

    public IgrejaComMembrosModel() {
        this(null,null);
    }

    public IgrejaComMembrosModel(IgrejaModel igreja, List<MembroModel> membroModels) {
        this.igreja = igreja;
        this.membroModels = membroModels;
    }

    public IgrejaModel getIgreja() {
        return igreja;
    }

    public void setIgreja(IgrejaModel igreja) {
        this.igreja = igreja;
    }

    public List<MembroModel> getMembroModels() {
        return membroModels;
    }

    public void setMembroModels(List<MembroModel> membroModels) {
        this.membroModels = membroModels;
    }
}
