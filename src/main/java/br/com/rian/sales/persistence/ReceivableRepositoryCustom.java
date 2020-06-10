package br.com.rian.sales.persistence;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import br.com.rian.sales.filters.SalesFilter;
import br.com.rian.sales.model.QReceivable;
import br.com.rian.sales.model.Receivable;

@Repository
public interface ReceivableRepositoryCustom
    extends MongoRepository<Receivable, String>, QuerydslPredicateExecutor<Receivable> {

    default Iterable<Receivable> recoverReceivablesByscheduleDate(SalesFilter filter) {

        QReceivable model = new QReceivable("");

        return this.findAll(model.merchantId.in(filter.getIdsStelo())
            .and(model.paymentScheduleDate.between(filter.getDataInicioFormatada(), filter.getDataFimFormatada())));

    }

    List<Readable> findByMerchantId(Long merchantId);

}
