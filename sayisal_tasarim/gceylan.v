module gceylan (KEY, HEX0, HEX1, HEX2, HEX3, HEX4, HEX5, HEX6, HEX7);
	
	input [3:0] KEY;
	output [0:6] HEX0, HEX1, HEX2, HEX3, HEX4, HEX5, HEX6, HEX7;
	
	reg  [3:0] G1=4'd1;
	reg  [3:0] G10=4'd0;
	
	reg  [3:0] A1=4'd1;
	reg  [3:0] A10=4'd0;
	
	reg  [3:0] Y1=4'd9;
	reg  [3:0] Y10=4'd9;
	reg  [3:0] Y100=4'd9;
	reg  [3:0] Y1000=4'd1;
	

	always @(posedge KEY[0]) begin
		if (G1 == 4'd1 & G10 == 4'd3) begin
			G10 = 4'd0;
		end
		else if (G1 == 4'd9) begin
			G1 = 4'd0;
			G10 = G10 + 4'd1;
		end
		else
			G1 = G1 + 4'd1;
	end
	
	always @(posedge KEY[1]) begin
		if (A1 == 4'd2 & A10 == 4'd1) begin
			A1 = 4'd1;
			A10 = 4'd0;
		end
		else if (A1 == 4'd9) begin
			A1 = 4'd0;
			A10 = A10 + 4'd1;
		end
		else
			A1 = A1 + 4'd1;
	end
	
	always @ (posedge KEY[2]) begin
		if (Y1000 == 4'd1 & Y100 == 4'd9 & Y10 == 4'd9 & Y1 == 4'd9) begin
			Y1000 = 4'd2;
			Y100 = 4'd0;
			Y10 = 4'd0;
			Y1 = 4'd0;
		end
		else if (Y1000 == 4'd2 & Y100 == 4'd0 & Y1 == 4'd9) begin
			Y10 = Y10 + 4d'1;
			Y1 = 4d'0;
		end
		else if (Y1000 == 4'd2 & Y100 == 4'd0 & Y10 == 4'd3 & Y1 == 4'd0) begin
			Y1000 = 4'd1;
			Y100 = 4'd9;
			Y10 = 4'd9;
			Y1 = 4'd9;
		end
		else
			Y1 = Y1 + 4d'1;
	end

	
	bcd7seq digit0(G10, HEX7);
	bcd7seq digit1(G1, HEX6);
	bcd7seq digit2(A10, HEX5);
	bcd7seq digit3(A1, HEX4);
	bcd7seq digit4(Y1000, HEX3);
	bcd7seq digit5(Y100, HEX2);
	bcd7seq digit6(Y10, HEX1);
	bcd7seq digit7(Y1, HEX0);
	
endmodule

module bcd7seq(bcd, display);
	
	input[3:0] bcd;
	output reg[0:6] display;
	
	always @ (bcd)
		case (bcd)
			4'h0: display = 7'b0000001;
			4'h1: display = 7'b1001111;
			4'h2: display = 7'b0010010;
			4'h3: display = 7'b0000110;
			4'h4: display = 7'b1001100;
			4'h5: display = 7'b0100100;
			4'h6: display = 7'b0100000;
			4'h7: display = 7'b0001111;
			4'h8: display = 7'b0000000;
			4'h9: display = 7'b0000100;
			default: display = 7'b1111111;
		endcase
endmodule
