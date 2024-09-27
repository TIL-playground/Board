package module.board.domain;

import module.board.common.DataProxy;
import module.board.common.Factory;
import org.springframework.stereotype.Component;

@Component
class ArticleDataFactory implements Factory<ArticleDto> {
    private final DataProxy<ArticleDto> dataProxy;

    private ArticleDataFactory(final ArticleDataProxy dataProxy, final ArticleDataLongProxy dataLongProxy) {
        dataProxy.addProxy(dataLongProxy);
        this.dataProxy = dataProxy;
    }

    @Override
    public DataProxy<ArticleDto> get() {
        return dataProxy;
    }
}
