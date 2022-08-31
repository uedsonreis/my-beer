package com.uedsonreis.mybeer.util;
import org.hibernate.proxy.HibernateProxy;
import org.modelmapper.Condition;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component
public class Mapper extends io.github.uedsonreis.libwscrud.api.util.Mapper {

    public Mapper() {
        super();
        super.getConfiguration().setPropertyCondition(new Condition<Object, Object>() {
            public boolean applies(MappingContext<Object, Object> context) {
                Object source = context.getSource();
                if (source == null) return false;
                if (source instanceof HibernateProxy) return false;
                return true;
            }
        });
    }
}
