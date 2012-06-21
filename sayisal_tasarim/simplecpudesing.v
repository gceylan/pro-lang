module simplecpudesing(clk, rst, PC);

  parameter im_size = 8;
  parameter rf_size = 4;
  
  input clk;
  output PC;
  input rst;
  
  parameter s_fetch = 2'b00;
  parameter s_decode = 2'b01;
  parameter s_execute = 2'b10;
  parameter s_store = 2'b11;
  

  parameter opcode_size = 4;
  
  parameter LRI  = 4'b0001;
  parameter MV   = 4'b0010;
  parameter AND  = 4'b0011;
  parameter ADD  = 4'b0100;
  parameter SUB  = 4'b0101;
  parameter OR   = 4'b0110;
  parameter XOR  = 4'b0111;
  parameter MVNZK= 4'b1000;
  parameter SHIFT= 4'b1001;
  parameter HALT = 4'b0000;
  
  reg [ opcode_size + (rf_size*3) -1 : 0 ] IMEM[0: 2 ** im_size -1 ];
  reg [ 7:0 ] REGFILE[0: 2 ** rf_size -1 ];
  reg [ 7:0 ] W;
  
  reg [ im_size-1 : 0 ] PC;
  reg [ opcode_size + (rf_size*3) -1 : 0 ] IR;

  reg [ 1:0 ] current_state;
  reg [ 1:0 ] next_state;

  reg [ opcode_size-1 : 0 ] OPCODE;
  reg [ rf_size-1 : 0 ] RA;
  reg [ rf_size-1 : 0 ] RB;
  reg [ rf_size-1 : 0 ] RD;
  

  initial begin
      PC = 0;
      current_state = s_fetch;

      IMEM[0] = { LRI , 4'd00, 4'd00, 4'd00 };
      IMEM[1] = { LRI , 4'd02, 4'd04, 4'd01 };
      IMEM[2] = { LRI , 4'd01, 4'd11, 4'd02 };
      IMEM[3] = { ADD, 4'd01, 4'd02, 4'd03 };
      IMEM[4] = { XOR, 4'd02, 4'd03, 4'd04 };
      IMEM[5] = { OR  , 4'd02, 4'd01, 4'd00 };
      IMEM[6] = { HALT, 12'd0 };
      end
  
  always @ (clk, rst)
  begin
      if(rst) begin
          current_state = s_fetch;
          PC = 0;
          end
      else
         begin
          case( current_state )
              s_fetch: begin
                  IR = IMEM[ PC ];
                  next_state = s_decode;
                  end
  
              s_decode: begin
                  PC = PC + 1;
                  next_state = s_execute;
                  
                  OPCODE = IR[ opcode_size + (rf_size*3) -1 : (rf_size*3) ];
                  RA = IR[ (rf_size*3) -1 : (rf_size*2) ];
                  RB = IR[ (rf_size*2) -1 : (rf_size  ) ];
                  RD = IR[ (rf_size  ) -1 : 0 ];
                  end
  
              s_execute: begin
                  case (OPCODE)
		      MV: begin
                         REGFILE[RD] = W;
                         next_state = s_fetch;
		      end

                      LRI: begin
                         W = {RA, RB};
                         next_state = s_store;
                         end
                         
                      ADD: begin
                          W = REGFILE[RA] + REGFILE[RB];
                          next_state = s_store;
                          end
		      SUB: begin
			  W = REGFILE[RA] - REGFILE[RB];
			  next_state = s_store;
                          end
		      
		      AND: begin
			  W = REGFILE[RA] & REGFILE[RB];
			  next_state = s_store;
                          end
                          
                      OR: begin    
                         W = REGFILE[RA] | REGFILE[RB];
                         next_state = s_store;
                         end
                          
                      XOR: begin    
                         W = REGFILE[RA] ^ REGFILE[RB];
                         next_state = s_store;
                         end
                          
                      HALT: begin
                         next_state = s_execute;
                         end
		      
		      SHIFT: begin
			 W = REGFILE[RA] << REGFILE[RB];
			 next_state = s_store;
		      end

		      MVNZK: begin
              		 if (!RD) begin
                            REGFILE[RD] = W;
	                    next_state = s_fetch;
			 end
		      end
                          
                      default: begin end
                  endcase
                  end
	      
	      s_store: begin
                 REGFILE[RD] = W;
                 next_state = s_fetch;
              end
              
              default: begin end
          endcase
  
          current_state = next_state;
      end
  end
  
endmodule
