package br.com.churchapi.v1.api.conversor;

import br.com.churchapi.v1.api.models.IgrejaModel;
import br.com.churchapi.v1.api.models.enumsmodel.StatusIgrejaModel;
import br.com.churchapi.v1.core.entidade.Igreja;
import br.com.churchapi.v1.core.utils.UtilitariosDeConversao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static br.com.churchapi.v1.core.enums.StatusIgreja.ATIVO;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ConversorDeIgrejaTest {

    @InjectMocks
    ConversorDeIgreja conversorDeIgreja;

    @Mock
    UtilitariosDeConversao conversao;

    @Test
    public void toEntidadeTest(){
        Igreja igreja = new Igreja(1,"teste","12345678912345","aaa",ATIVO);
        IgrejaModel igrejaM = new IgrejaModel(1,"teste","12345678912345","aaa", StatusIgrejaModel.ATIVO);

        when(conversao.converter(any(),any(IgrejaModel.class))).thenReturn(igreja);

        conversorDeIgreja.toEntidade(igrejaM);

    }

    @Test
    public void toModeloTest(){
        Igreja igreja = new Igreja(1,"teste","12345678912345","aaa", ATIVO);
        IgrejaModel igrejaM = new IgrejaModel(1,"teste","12345678912345","aaa", StatusIgrejaModel.ATIVO);

        when(conversao.converter(any(),any(Igreja.class))).thenReturn(igrejaM);

        conversorDeIgreja.toModel(igreja);

    }

    @Test
    public void toListModeloTest(){
        Igreja igreja = new Igreja(1,"teste","12345678912345","aaa", ATIVO);
        IgrejaModel igrejaM = new IgrejaModel(1,"teste","12345678912345","aaa", StatusIgrejaModel.ATIVO);
        List<Igreja> igrejas = new ArrayList<>();
        List<IgrejaModel> igrejaModels = new ArrayList<>();
        igrejas.add(igreja);
        igrejaModels.add(igrejaM);
        when(conversao.converterList(any(),anyList())).thenReturn(Collections.singletonList(igrejaModels));

        conversorDeIgreja.toListModel(igrejas);

    }

    @Test
    public void toListEntidadeTest(){
        Igreja igreja = new Igreja(1,"teste","12345678912345","aaa", ATIVO);
        IgrejaModel igrejaM = new IgrejaModel(1,"teste","12345678912345","aaa", StatusIgrejaModel.ATIVO);
        List<Igreja> igrejas = new ArrayList<>();
        List<IgrejaModel> igrejaModels = new ArrayList<>();
        igrejas.add(igreja);
        igrejaModels.add(igrejaM);
        when(conversao.converterList(any(),anyList())).thenReturn(Collections.singletonList(igrejas));

        conversorDeIgreja.toListEntidade(igrejaModels);

    }

    @Test
    public void fromModelTest() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Igreja igreja = new Igreja(1,"teste","12345678912345","aaa", ATIVO);
        IgrejaModel igrejaM = new IgrejaModel(1,"teste","12345678912345","aaa", StatusIgrejaModel.ATIVO);
        Method method = ConversorDeIgreja.class.getDeclaredMethod("fromModel", IgrejaModel.class);
        method.setAccessible(true);
        ConversorDeIgreja conversorDeIgreja = new ConversorDeIgreja();
        Object t = method.invoke(conversorDeIgreja,igrejaM);
        Assert.assertEquals(t,igreja);

    }

    @Test
    public void fromEntidadeTest() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
        Igreja igreja = new Igreja(1,"teste","12345678912345","aaa", ATIVO);
        Method method = ConversorDeIgreja.class.getDeclaredMethod("fromEntidade", Igreja.class);
        method.setAccessible(true);
        ConversorDeIgreja conversorDeIgreja = new ConversorDeIgreja();
        Object retorno = method.invoke(conversorDeIgreja,igreja);
        Assert.assertNotNull(retorno);

    }

    @Test
    public void toEntidadeStatusTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = ConversorDeIgreja.class.getDeclaredMethod("toEntidadeStatus", StatusIgrejaModel.class);
        method.setAccessible(true);
        ConversorDeIgreja conversorDeIgreja = new ConversorDeIgreja();
        Object retorno = method.invoke(conversorDeIgreja,StatusIgrejaModel.ATIVO);
        Assert.assertNotNull(retorno);
    }
    @Test
    public void toEntidadeStatusTestInativo() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = ConversorDeIgreja.class.getDeclaredMethod("toEntidadeStatus", StatusIgrejaModel.class);
        method.setAccessible(true);
        ConversorDeIgreja conversorDeIgreja = new ConversorDeIgreja();
        Object retorno = method.invoke(conversorDeIgreja,StatusIgrejaModel.INATIVO);
        Assert.assertNotNull(retorno);
    }
}
