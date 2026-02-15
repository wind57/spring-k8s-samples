package wind57;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FrontController {

  private final BackendRequestSubmitter backendRequestSubmitter;

  @Autowired
  private DiscoveryClient discoveryClient;

  @Autowired
  public FrontController(BackendRequestSubmitter backendRequestSubmitter) {
    this.backendRequestSubmitter = backendRequestSubmitter;
  }

  @GetMapping(value = "/healthcheck")
  public String healthcheck() {
    return "OK";
  }

  @GetMapping(value = "/")
  public String index() {
    return backendRequestSubmitter.submitRequest();
  }

  @GetMapping(value = "/test")
  public void test() {
	  List<String> services = discoveryClient.getServices();
	  System.out.println("services : " + services);

	  for (String service : services) {
		  List<ServiceInstance> serviceInstances = discoveryClient.getInstances(service);
		  System.out.println("serviceInstances : " + serviceInstances);
	  }
  }
}
