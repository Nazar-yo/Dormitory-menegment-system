package com.example.dormitory.mapper;

import com.example.dormitory.dto.SettlementApplicationRequestDto;
import com.example.dormitory.dto.SettlementApplicationResponseDto;
import com.example.dormitory.model.SettlementApplication;
import org.springframework.stereotype.Component;

@Component
public class SettlementApplicationMapper implements RequestDtoMapper<SettlementApplicationRequestDto, SettlementApplication>,
        ResponseDtoMapper<SettlementApplicationResponseDto, SettlementApplication> {

    private final RoomMapper roomMapper;

    public SettlementApplicationMapper(RoomMapper roomMapper) {
        this.roomMapper = roomMapper;
    }

    @Override
    public SettlementApplication mapToModel(SettlementApplicationRequestDto dto) {
        SettlementApplication settlementApplication = new SettlementApplication();
        settlementApplication.setApplicationStatus(dto.getApplicationStatus());
        settlementApplication.setSettlementEndDate(dto.getSettlementEndDate());
        settlementApplication.setSettlementStartDate(dto.getSettlementStartDate());
        settlementApplication.setCreationDate(dto.getCreationDate());

        return settlementApplication;
    }

    @Override
    public SettlementApplicationResponseDto mapToDto(SettlementApplication settlementApplication) {
        SettlementApplicationResponseDto responseDto = new SettlementApplicationResponseDto();
        responseDto.setId(settlementApplication.getId());
        responseDto.setApplicationStatus(settlementApplication.getApplicationStatus());
        if (settlementApplication.getRoom() != null) {
            responseDto.setDesiredRoom(this.roomMapper.mapToDto(settlementApplication.getRoom()));
        }
        responseDto.setSettlementEndDate(settlementApplication.getSettlementEndDate());
        responseDto.setSettlementStartDate(settlementApplication.getSettlementStartDate());
        responseDto.setCreationDate(settlementApplication.getCreationDate());
        responseDto.setApplicantId(settlementApplication.getId());

        return responseDto;
    }
}
