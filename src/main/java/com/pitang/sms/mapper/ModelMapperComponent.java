package com.pitang.sms.mapper;

import javax.annotation.PostConstruct;

import com.pitang.sms.dto.*;
import com.pitang.sms.model.*;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperComponent {
	public static final ModelMapper modelMapper = new ModelMapper();
	
	@PostConstruct
	private void configureMapper() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		modelMapper.addMappings(
				new PropertyMap<UserModel, UserDto>() {
					@Override
					protected void configure() {
						map().setId(source.getId());
						map().setName(source.getName());
						map().setUserName(source.getUserName());
						map().setEmail(source.getEmail());
						map().setPassword(null);
						when(Conditions.isNotNull()).using(ModelConverter.convertStatus).map(source.isStatus()).setStatus(null);
						map().setContactsSrc(source.getContactSrc());
						map().setContactsDst(source.getContactDst());

					}
				});

		modelMapper.addMappings(
				new PropertyMap<UserDto, UserModel>() {
					@Override
					protected void configure() {
						map().setId(source.getId());
						map().setName(source.getName());
						map().setUserName(source.getUserName());
						map().setPassword(source.getPassword());
						map().setEmail(source.getEmail());
						when(Conditions.isNotNull()).using(ModelConverter.convertStatusToBoolean).map(source.getStatus()).setStatus(false);

					}
				});


		modelMapper.addMappings(
				new PropertyMap<UserProfileDto, UserProfile>() {
					@Override
					protected void configure() {
						map().setId(source.getId());
						map().setAddress1(source.getAddress1());
						map().setAddress2(source.getAddress2());
						map().setCity(source.getCity());
						map().setCountry(source.getCountry());
						using(ModelConverter.fromStringToDate).map(source.getDateOfBirth()).setDateOfBirth(null);
						map().setPhoneNumber(source.getPhoneNumber());
						map().setState(source.getState());
						map().setStreet(source.getStreet());
						map().setZipCode(source.getZipCode());
						skip().setUser(null);

					}
				});

		modelMapper.addMappings(
				new PropertyMap<UserProfile, UserProfileDto>() {
					@Override
					protected void configure() {
						map().setId(source.getId());
						map().setAddress1(source.getAddress1());
						map().setAddress2(source.getAddress2());
						map().setCity(source.getCity());
						map().setCountry(source.getCountry());
						using(ModelConverter.fromDateToString).map(source.getDateOfBirth()).setDateOfBirth(null);
						map().setPhoneNumber(source.getPhoneNumber());
						map().setState(source.getState());
						map().setStreet(source.getStreet());
						map().setZipCode(source.getZipCode());
					}
				});

		modelMapper.addMappings(
				new PropertyMap<MessageDto, MessageModel>() {
					@Override
					protected void configure() {
						map().setId(source.getId());
						map().setIdSrc(source.getIdSrc());
						map().setIdDst(source.getIdDst());
						map().setLocalDatetime(source.getLocalDateTime());
						map().setMessage(source.getMessage());
						map().setStatusSrc(source.getStatusSrc());
						map().setStatusDst(source.getStatusDst());
						}
				});

		modelMapper.addMappings(
				new PropertyMap<MessageModel, MessageDto>() {
					@Override
					protected void configure() {
						map().setId(source.getId());
						map().setIdSrc(source.getIdSrc());
						map().setIdDst(source.getIdDst());
						map().setLocalDateTime(source.getLocalDatetime());
						map().setMessage(source.getMessage());
						map().setStatusSrc(source.getStatusSrc());
						map().setStatusDst(source.getStatusDst());
					}
				});

		modelMapper.addMappings(
				new PropertyMap<ProfileDto, ProfileModel>() {
					@Override
					protected void configure(){
						map().setId(source.getId());
						map().setUrlImage(source.getUrlImage());
					}
				});

		modelMapper.addMappings(
				new PropertyMap<ProfileModel, ProfileDto>() {
					@Override
					protected void configure(){
						map().setId(source.getId());
						map().setUrlImage(source.getUrlImage());
					}
				}
		);

		modelMapper.addMappings(
				new PropertyMap<ContactDto, ContactModel>() {
					@Override
					protected void configure(){
						map().setId(source.getId());
						map().setIdOwner(source.getIdOwner());
						map().setIdTarget(source.getIdTarget());
					}
				}
		);

		modelMapper.addMappings(
				new PropertyMap<ContactModel, ContactDto>() {
					@Override
					protected void configure(){
						map().setId(source.getId());
						map().setIdOwner(source.getIdOwner());
						map().setIdTarget(source.getIdTarget());
					}
				}
		);

		modelMapper.addMappings(
				new PropertyMap<HistoryPasswordDto, HistoryPasswordModel>() {
					@Override
					protected void configure(){
						map().setId(source.getId());
						map().setIdUser(source.getIdUser());
						map().setPassword(source.getPassword());
					}
				}
		);

		modelMapper.addMappings(
				new PropertyMap<HistoryPasswordModel, HistoryPasswordDto>() {
					@Override
					protected void configure(){
						map().setId(source.getId());
						map().setIdUser(source.getIdUser());
						map().setPassword(source.getPassword());
					}
				}
		);

		modelMapper.addMappings(
				new PropertyMap<StoryDto, StoryModel>() {
					@Override
					protected void configure(){
						map().setId(source.getId());
						map().setIdSrc(source.getIdSrc());
						map().setMessage(source.getMessage());
						map().setLocalDateTime(source.getLocalDateTime());
						map().setType(source.getType());
					}
				}
		);

		modelMapper.addMappings(
				new PropertyMap<StoryModel, StoryDto>() {
					@Override
					protected void configure(){
						map().setId(source.getId());
						map().setIdSrc(source.getIdSrc());
						map().setMessage(source.getMessage());
						map().setLocalDateTime(source.getLocalDateTime());
						map().setType(source.getType());
					}
				}
		);
	}
}