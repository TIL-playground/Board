package module.board.application;

import module.board.common.proxy.CrudProxy;
import module.board.common.factory.Factory;
import org.springframework.stereotype.Component;

@Component
class ArticleCrudFactory implements Factory<ArticleDto> {
    private final CrudProxy<ArticleDto> crudProxy;
    
    private ArticleCrudFactory(final ArticleDtoCrudProxy crudProxy, final ArticleLongCrudProxy longCrudProxy) {
        crudProxy.addProxy(longCrudProxy);
        this.crudProxy = crudProxy;
    }

    @Override
    public CrudProxy<ArticleDto> get() {
        return crudProxy;
    }
}
