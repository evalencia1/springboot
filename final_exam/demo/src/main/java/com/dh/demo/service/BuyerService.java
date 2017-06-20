package com.dh.demo.service;

import com.dh.demo.domain.Buyer;
import com.dh.demo.domain.RegistryCarSold;
import com.dh.demo.repository.BuyerRepository;
import com.dh.demo.web.BuyerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ElmerVL on 19/06/2017.
 */
@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private RegistryCarSoldService registryCarSoldService;

    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    public void addBuyer(BuyerController.BuyerRequestDTO buyerDTO) {
        Buyer buyer = new Buyer();
        buyer.setCi(buyerDTO.getCi());
        buyer.setName(buyerDTO.getName());
        buyer.setCel(buyerDTO.getCel());
        buyer.setProfession(buyerDTO.getProfession());

        buyerRepository.save(buyer);
    }

    public void updateBuyer(Long id, BuyerController.BuyerRequestDTO buyerDTO) {

        Buyer buyer = buyerRepository.findOne(id);
        if (null != buyerDTO.getCi()) {buyer.setCi(buyerDTO.getCi());}
        if (null != buyerDTO.getName()) {buyer.setName(buyerDTO.getName());}
        if (null != buyerDTO.getCel()) {buyer.setCel(buyerDTO.getCel());}
        if (null != buyerDTO.getProfession()) {buyer.setProfession(buyerDTO.getProfession());}

        buyerRepository.save(buyer);
    }

    public void deleteBuyer(Long id) {

        List<RegistryCarSold> registryCarSoldList = registryCarSoldService.getAllRegistryCarSolds();

        for (RegistryCarSold registryCarSold : registryCarSoldList) {
            Buyer buyer = registryCarSold.getBuyer();
            if (buyer.getId() == id) {
                registryCarSoldService.deleteRegistryCarSold(registryCarSold.getId());
            }
        }

        buyerRepository.delete(id);
    }
}
