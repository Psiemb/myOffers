package myApplications.myOffers.controller;

import myApplications.myOffers.dao.OfferDataBase;
import myApplications.myOffers.mapper.AverageValueWinningBidResponseMapper;
import myApplications.myOffers.mapper.NameRandomResponseMapper;
import myApplications.myOffers.response.AverageValueWinningBidResponse;
import myApplications.myOffers.response.NameRandomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferController {

    @Autowired
    private AverageValueWinningBidResponseMapper averageValueWinningBidResponseMapper;

    @Autowired
    private NameRandomResponseMapper nameRandomResponseMapper;

    @Autowired
    private OfferDataBase offerDataBase;

    @GetMapping("/offer")
    public ResponseEntity<AverageValueWinningBidResponse> offer() {
        AverageValueWinningBidResponse averageValueWinningBidResponse = averageValueWinningBidResponseMapper.maToResponse(offerDataBase.getOffers());
        return ResponseEntity.ok(averageValueWinningBidResponse);
    }

    @GetMapping("/name")
    public ResponseEntity<NameRandomResponse> getName() {
        NameRandomResponse nameRandomResponse = nameRandomResponseMapper.mapToResponse(offerDataBase.getOffers());
        return ResponseEntity.ok(nameRandomResponse);
    }

}
