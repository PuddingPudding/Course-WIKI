import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.acer.course_wiki.R;
import com.example.acer.course_wiki.commentClass;

import java.util.ArrayList;

/**
 * Created by arial on 2016/6/15.
 */
public class commentadapter extends ArrayAdapter<commentClass>
{
    Context context;

    public commentadapter(Context context, ArrayList<commentClass> commentItem)
    {
        super(context , 0 , commentItem);
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        LinearLayout commentlayout = null;

        if (convertView == null) {
            commentlayout = (LinearLayout) inflater.inflate(R.layout.comment_item, null);
        } else {
            commentlayout = (LinearLayout) convertView;
        }

        commentClass commentitem = (commentClass) getItem(position);

        TextView ID = (TextView) commentlayout.findViewById(R.id.comment_ID);
        ID.setText(commentitem.getID());

        TextView comment = (TextView) commentlayout.findViewById(R.id.comment);
        comment.setText(commentitem.getComment());

        TextView givingRank = (TextView) commentlayout.findViewById(R.id.givingRank);
        givingRank.setText("" + commentitem.getGivingRank());

        return commentlayout;
    }
}
