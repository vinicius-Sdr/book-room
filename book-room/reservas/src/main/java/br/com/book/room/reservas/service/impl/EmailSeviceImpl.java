package br.com.book.room.reservas.service.impl;

import br.com.book.room.reservas.model.Email;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSeviceImpl {

	private final JavaMailSender mailSender;

	public EmailSeviceImpl(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendEmail(Email email) {
		var message = new SimpleMailMessage();
		message.setFrom("noreply@email.com");
		message.setTo(email.to());
		message.setSubject(email.subject());
		message.setText(email.body());
		mailSender.send(message);
	}

}
