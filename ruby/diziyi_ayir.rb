#!usr/bin/ruby
#encoding: utf-8

def diziyi_ayir(dizi, n=2)
  dizi.shuffle[0..n - 1]
end

puts diziyi_ayir((1..10).to_a, 3)
