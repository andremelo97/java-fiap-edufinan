package br.com.fiap.edufinan.entities.enums;

import br.com.fiap.edufinan.entities.enums.OrderStatus;

public enum OrderStatus {
	
	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENTREGUE(3),
	CANCELADO(0);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("INVALID ORDER STATUS CODE");
	}
}