package hessam.rastegari.weroom;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class ChatFragment extends Fragment {

    WebSocket webSocket;
    MessageAdapter adapter;

    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_chat, container, false);


        ListView messageList = v.findViewById(R.id.messageList);
        EditText messageBox = v.findViewById(R.id.messageBox);
        TextView send = v.findViewById(R.id.send);

        instantiateWebSocket();
        adapter = new MessageAdapter();
        messageList.setAdapter(adapter);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String message = messageBox.getText().toString();



                if (!message.isEmpty()) {


                    webSocket.send(message);
                    messageBox.setText("");



                    JSONObject jsonObject = new JSONObject();

                    try {


                        jsonObject.put("message", message);
                        jsonObject.put("byServer", false);

                        adapter.addItem(jsonObject);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        return v;
    }

    private void instantiateWebSocket() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("ws://192.168.1.5:8080").build();
        SocketListener socketListener = new SocketListener(getActivity());
        webSocket = client.newWebSocket(request, socketListener);


    }

    public class SocketListener extends WebSocketListener {

        public FragmentActivity fragmentActivity;

        public SocketListener(FragmentActivity fragmentActivity) {
            this.fragmentActivity = fragmentActivity;
        }

        @Override
        public void onOpen(WebSocket webSocket, Response response) {
            super.onOpen(webSocket, response);
            fragmentActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(fragmentActivity, "Connection Established!", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public void onMessage(WebSocket webSocket, String text) {
            super.onMessage(webSocket, text);

            fragmentActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("message", text);
                        jsonObject.put("byServer", true);

                        adapter.addItem(jsonObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


        @Override
        public void onClosing(WebSocket webSocket, int code, String reason) {
            super.onClosing(webSocket, code, reason);
        }

        @Override
        public void onClosed(WebSocket webSocket, int code, String reason) {
            super.onClosed(webSocket, code, reason);
        }

        @Override
        public void onFailure(WebSocket webSocket, Throwable t, Response response) {
            super.onFailure(webSocket, t, response);
        }
    }


    public class MessageAdapter extends BaseAdapter {


        List<JSONObject> messagesList = new ArrayList<>();


        @Override
        public int getCount() {
            return messagesList.size();
        }

        @Override
        public Object getItem(int i) {
            return messagesList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if (view == null)
                view = getLayoutInflater().inflate(R.layout.message_list_tem, viewGroup, false);


            TextView sentMessage = view.findViewById(R.id.sentMessage);
            TextView receivedMessage = view.findViewById(R.id.recievedMessage);


            JSONObject item = messagesList.get(i);


            try {

                if (item.getBoolean("byServer")) {


                    receivedMessage.setVisibility(View.VISIBLE);
                    receivedMessage.setText(item.getString("message"));


                    sentMessage.setVisibility(View.INVISIBLE);


                } else {


                    sentMessage.setVisibility(View.VISIBLE);
                    sentMessage.setText(item.getString("message"));


                    receivedMessage.setVisibility(View.INVISIBLE);


                }

            } catch (JSONException e) {
                e.printStackTrace();
            }


            return view;
        }


        void addItem(JSONObject item) {


            messagesList.add(item);
            notifyDataSetChanged();


        }
    }
}