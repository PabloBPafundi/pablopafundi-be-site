package com.pablopafundi.site.portfolio;


import org.springframework.stereotype.Service;

@Service
public class PortfolioMapper {


    public Portfolio toPortfolio(PortfolioDTO portfolioDTO) {

        return new Portfolio(portfolioDTO.name(), portfolioDTO.description(), portfolioDTO.dateCompleted(), portfolioDTO.urlRepository());
    }

    public PortfolioResponseDTO ToPortfolioResponseDTO(Portfolio portfolio) {

        return new PortfolioResponseDTO(portfolio.getName(), portfolio.getDescription(), portfolio.getDateCompleted(), portfolio.getUrlRepository());
    }

}
