import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.OrderByElement;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectExpressionItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuildSqlStr {
    public static void main(String[] args) throws JSQLParserException {

        Select select = new Select();
        PlainSelect body = new PlainSelect();

        body.addSelectItems(
                new SelectExpressionItem(new Column("a")),
                new SelectExpressionItem(new Column("b")));

        body.setFromItem(new Table("a.mytable"));

//        List<StringValue> groupByList = Arrays.asList(
//                new StringValue("a"),
//                new StringValue("b")
//        );
//        body.setGroupByColumnReferences(groupByList);

        OrderByElement orderBy = new OrderByElement();
        orderBy.setExpression(new Column("a"));
        orderBy.setAsc(false);
        List<OrderByElement> orderByElements = new ArrayList<OrderByElement>();
        orderByElements.add(orderBy);
        body.setOrderByElements(orderByElements);

        select.setSelectBody(body);

        System.out.println(select.toString());
    }
}