package Controllers;


import Entities.Radar;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import query.GetRadarByIdQuery;
import query.Queries;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RadarQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/all")
    public CompletableFuture<List<Radar>> customers(){
        return queryGateway.query(new Queries(),
                ResponseTypes.multipleInstancesOf(Radar.class));
    }

    @GetMapping("/byId/{id}")
    public CompletableFuture<Radar> getCustomer(@PathVariable String id){
        return queryGateway.query(new GetRadarByIdQuery(id),
                ResponseTypes.instanceOf(Radar.class));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        ResponseEntity<String > responseEntity=
                new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }
}
