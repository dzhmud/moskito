package net.anotheria.moskito.webui.more.action;

import net.anotheria.maf.action.ActionCommand;
import net.anotheria.maf.action.ActionMapping;
import net.anotheria.maf.bean.FormBean;
import net.anotheria.moskito.webui.shared.api.ErrorCatcherAO;
import net.anotheria.moskito.webui.shared.bean.NaviItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 05.06.17 23:31
 */
public class ShowErrorsAction extends BaseAdditionalAction {
	@Override
	protected String getLinkToCurrentPage(HttpServletRequest req) {
		return null;
	}

	@Override
	public ActionCommand execute(ActionMapping mapping, FormBean formBean, HttpServletRequest req, HttpServletResponse res) throws Exception {

		List<ErrorCatcherAO> catchers = getAdditionalFunctionalityAPI().getActiveErrorCatchers();
		if (catchers!=null && catchers.size()>0)
			req.setAttribute("catchers", catchers);

		return mapping.success();
	}

	@Override
	protected String getPageName() {
		return "errors";
	}

	@Override
	protected NaviItem getCurrentSubNaviItem() {
		return NaviItem.MORE_ERRORS;
	}

	@Override
	protected String getSubTitle() {
		return "Errors";
	}
}
