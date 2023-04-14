import java.util.ArrayList;

public class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
class Handler1 implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    ArrayList list = new ArrayList<>();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("List: %d", list);
        }else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    list.append(parameters[1]);
                    return String.format("List increased by %s! It's now %d", parameters[1], list);
                }
            }
            if (url.getPath().contains("/search")){
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    ArrayList list2 = new ArrayList<>();
                    for (lst : list){
                        if (lst.contains(parameters[1]){
                            list2.append(lst)
                        }
                    }
                    
                    return String.format("List increased by %s! It's now %d", parameters[1], list);
                }
            }
            return "404 Not Found!";
        }
        }
    }
}
