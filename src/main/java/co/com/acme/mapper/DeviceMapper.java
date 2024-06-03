package co.com.acme.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.com.acme.dto.DeviceDTO;
import co.com.acme.model.Device;

@Mapper(componentModel = "spring")
public interface DeviceMapper {

	DeviceDTO deviceToDeviceDTO(Device device);

	Device deviceDTOToDevice(DeviceDTO deviceDTO);

	List<DeviceDTO> listDeviceToListDeviceDTO(List<Device> devices);

	List<Device> listDeviceDTOToListDevice(List<DeviceDTO> devicesDTO);

}
