package com.dh.demo.web;

import com.dh.demo.domain.Buyer;
import com.dh.demo.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ElmerVL on 19/06/2017.
 */
@RestController
@RequestMapping("/buyers")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Buyer> getAllBuyers() {
        return buyerService.getAllBuyers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addCar(@RequestBody BuyerRequestDTO buyerDTO) {
        buyerService.addBuyer(buyerDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable Long id, @RequestBody BuyerRequestDTO buyerDTO) {
        buyerService.updateBuyer(id, buyerDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBuyer(@PathVariable Long id) {
        buyerService.deleteBuyer(id);
    }


    public static class BuyerRequestDTO {

        private String name;

        private Integer ci;

        private String profession;

        private Integer cel;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getCi() {
            return ci;
        }

        public void setCi(Integer ci) {
            this.ci = ci;
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }

        public Integer getCel() {
            return cel;
        }

        public void setCel(Integer cel) {
            this.cel = cel;
        }
    }
}
