package br.com.rian.sales.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rian.sales.constants.ConstantsUtil;
import br.com.rian.sales.filters.SalesFilter;
import br.com.rian.sales.persistence.ReceivableRepositoryCustom;

@Service
public class ReceivableService {

    @Autowired
    ServiceUtilits serviceUtilits;

    @Autowired
    ReceivableRepositoryCustom receivableRepositoryCustom;

    public void recoverReceivablesByscheduleDate(SalesFilter filter) {
        if (serviceUtilits.validarParametrosDatasInicioFim(filter.getDataInicio(), filter.getDataFim()) == true) {
            serviceUtilits.montarFiltroDataFormatado(filter.getDataInicio(), filter.getDataFim(), ConstantsUtil.DDMMYYYYHHMMSS_BR);
        }
        receivableRepositoryCustom.recoverReceivablesByscheduleDate(filter);
    }

}
