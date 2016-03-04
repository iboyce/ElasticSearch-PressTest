package es.oper;

import java.io.IOException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

public class ESBase {
	
	 private Client client;
	 
	 
	 public void init() {
		 
		 	Settings settings = ImmutableSettings.settingsBuilder()
			        .put("cluster.name", "xzes").build();
		 	
	        client = new TransportClient(settings)
	                .addTransportAddress(new InetSocketTransportAddress(
	                        "10.101.224.22", 9300));
	    }
	 
	    public void close() {
	        client.close();
	    }
	 
	    /**
	     * index
	     */
	    public void createIndex(int i_docs) {
	        for (int i = 0; i < i_docs; i++) {
	            User user = new User();
	            user.setId(new Long(i));
	            user.setName("huang fox " + i);
	            user.setAge(i % 100);
	            client.prepareIndex("users", "user").setSource(generateJson(user))
	                    .execute().actionGet();
	            
	            System.out.println("已入索引："+ i+ "条");
	        }
	    }
	 
	    /**
	     * 转换成json对象
	     *
	     * @param user
	     * @return 
	     */
	    private String generateJson(User user) {
	        String json = "";
	        try {
	            XContentBuilder contentBuilder = XContentFactory.jsonBuilder()
	                    .startObject();
	            contentBuilder.field("id", user.getId() + "");
	            contentBuilder.field("name", user.getName());
	            contentBuilder.field("age", user.getAge() + "");
	            json = contentBuilder.endObject().string();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return json;
	    }
	
	

}
