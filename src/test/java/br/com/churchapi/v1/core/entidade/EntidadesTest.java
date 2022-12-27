package br.com.churchapi.v1.core.entidade;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.Assert.assertThat;

public class EntidadesTest {


    @Test
    public void igrejaTest(){
        assertThat(Igreja.class, allOf(
                hasValidBeanConstructor(),
                hasValidGettersAndSetters()
        ));
    }

    @Test
    public void membroTest(){
        assertThat(Membro.class,allOf(hasValidBeanConstructor(),hasValidGettersAndSetters()));
    }
}
