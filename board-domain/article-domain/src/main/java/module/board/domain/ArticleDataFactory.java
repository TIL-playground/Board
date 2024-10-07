package module.board.domain;

import module.board.common.DataProxy;
import module.board.common.Factory;
import org.springframework.stereotype.Component;

@Component
class ArticleDataFactory implements Factory<ArticleDto> {
    private final DataProxy<ArticleDto> dataProxy;

    private ArticleDataFactory(final ArticleDataDtoProxy dataDtoProxy, final ArticleDataLongProxy dataLongProxy, final ArticleDataProxy dataProxy) {
        dataProxy.addProxy(dataLongProxy);
        dataProxy.addProxy(dataDtoProxy);
        this.dataProxy = dataProxy;
    }

    @Override
    public DataProxy<ArticleDto> get() {
        return dataProxy;
    }
}
