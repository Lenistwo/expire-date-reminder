package pl.lenistwo.expire.utills;

import pl.lenistwo.expire.entities.Item;

import java.util.List;

public class MessageBuilder {

    public static String build(List<Item> items) {
        StringBuilder builder = new StringBuilder();
        builder.append("<h1> This Product will soon Expire </h1>");
        builder.append("<table>" +
                "    <tr>" +
                "        <th>Name</th>" +
                "        <th>Amount</th>" +
                "        <th>Expire Date</th>" +
                "    </tr>");
        items.forEach(s -> builder.append("<tr>" + "<td>").append(s.getItemName()).append("</td>").append("<td>").append(s.getAmount()).append("</td>").append("<td>").append(s.getExpireDate()).append("</td>").append("</tr>"));
        builder.append("</table>");
        return builder.toString();
    }
}
