package techkids.vn.everydayquote.network;

import techkids.vn.everydayquote.jsonmodels.QuoteJSONModel;
import techkids.vn.everydayquote.models.Quote;

/**
 * Created by apple on 10/11/16.
 */

public interface QuoteLoaderFinishHandler {
    void onFinish(QuoteJSONModel jsonModel);
}
