;;; Sierra Script 1.0 - (do not remove this comment)
(script# 995)
(include sci.sh)
(use Main)
(use Print)
(use IconI)
(use SysWindow)
(use Obj)


(local
	local0
)
(procedure (localproc_07be param1 param2 param3 &tmp temp0 eventSel_109 temp2 temp3)
	(= temp3
		(+
			(/ (- (param1 sel_9?) (param1 sel_7?)) 2)
			(param1 sel_7?)
		)
	)
	(= temp2 param2)
	(return
		(while (>= (Abs (- temp2 param3)) 4)
			(if
				(= temp0
					(self
						sel_120:
							218
							((= eventSel_109 (Event sel_109:))
								sel_1: temp3
								sel_0: temp2
								sel_117:
							)
					)
				)
				(eventSel_109 sel_111:)
				(return temp0)
			)
			(eventSel_109 sel_111:)
			(if (< param2 param3)
				(= temp2 (+ temp2 4))
			else
				(= temp2 (- temp2 4))
			)
		)
	)
)

(class InvI of IconI
	(properties
		sel_20 {InvI}
		sel_2 0
		sel_3 0
		sel_4 0
		sel_7 0
		sel_6 0
		sel_9 0
		sel_8 0
		sel_29 0
		sel_33 999
		sel_31 16384
		sel_37 0
		sel_61 0
		sel_14 0
		sel_208 0
		sel_209 0
		sel_210 0
		sel_211 0
		sel_212 0
		sel_213 0
		sel_214 0
		sel_215 0
		sel_166 0
		sel_142 0
		sel_74 0
	)
	
	(method (sel_216 &tmp [temp0 4])
		(DrawCel sel_2 sel_3 sel_4 sel_7 sel_6 -1)
	)
	
	(method (sel_217 param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (== sel_211 -1) (return))
		(= temp4 (if (and argc param1) sel_211 else sel_212))
		(= temp0 (- sel_6 2))
		(= temp1 (- sel_7 2))
		(= temp2 (+ sel_8 1))
		(= temp3 (+ sel_9 1))
		(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
		(Graph
			grUPDATE_BOX
			(- sel_6 2)
			(- sel_7 2)
			(+ sel_8 2)
			(+ sel_9 2)
			1
		)
	)
	
	(method (sel_218 param1)
		(return
			(if (super sel_218: param1)
				(not (& sel_14 $0004))
			else
				0
			)
		)
	)
	
	(method (sel_353 param1)
		(return (== sel_166 param1))
	)
	
	(method (sel_182 theSel_166)
		(= sel_166 theSel_166)
		(if (and sel_74 (== theSel_166 gEgo))
			(gGame sel_388: sel_74)
			(= sel_74 0)
		)
		(return self)
	)
	
	(method (sel_300 param1)
		(if (not sel_214) (= sel_214 gSel_40))
		(if
			(and
				global90
				(Message msgGET sel_214 sel_213 param1 0 1)
			)
			(gLb2Messager sel_295: sel_213 param1 0 0 0 sel_214)
		)
	)
)

(class Inv of IconBar
	(properties
		sel_20 {Inv}
		sel_24 0
		sel_86 0
		sel_220 0
		sel_5 0
		sel_221 0
		sel_222 0
		sel_207 0
		sel_223 0
		sel_224 0
		sel_225 0
		sel_226 0
		sel_227 0
		sel_228 0
		sel_147 0
		sel_32 0
		sel_29 1024
		sel_229 0
		sel_0 0
		sel_389 {You are carrying:}
		sel_55 0
		sel_390 {nothing!}
		sel_391 0
		sel_392 0
		sel_393 0
	)
	
	(method (sel_110)
		(= sel_55 sel_389)
	)
	
	(method (sel_57 &tmp temp0 temp1 temp2 [temp3 3] temp6 temp7 temp8 temp9 [temp10 50])
		(asm
			pushi    #sel_116
			pushi    1
			pushi    236
			lag      gLb2Win
			send     6
			bnt      code_0863
			pushi    #sel_236
			pushi    0
			lag      gLb2Win
			send     4
			sat      temp7
			pushi    #sel_236
			pushi    1
			pushi    1
			lag      gLb2Win
			send     6
code_0863:
			pushi    #sel_31
			pushi    0
			pushi    #sel_109
			pushi    0
			class    Event
			send     4
			sat      temp1
			send     4
			bnt      code_087c
			pushi    #sel_111
			pushi    0
			lat      temp1
			send     4
			jmp      code_0863
code_087c:
			pushi    #sel_111
			pushi    0
			lat      temp1
			send     4
			ldi      0
			sat      temp1
code_0887:
			pTos     sel_29
			ldi      32
			and     
			bnt      code_0d0a
			pushi    #sel_31
			pushi    1
			pushi    0
			pushi    37
			pushi    1
			pushi    0
			pushi    61
			pushi    1
			pushi    0
			pushi    0
			pushi    1
			pushi    0
			pushi    1
			pushi    1
			pushi    0
			pushi    73
			pushi    1
			pushi    0
			pushi    147
			pushi    1
			pushi    0
			lofsa    invEvent
			send     42
			pushi    2
			pushi    32767
			lofsa    invEvent
			push    
			callk    GetEvent,  4
			pushi    #sel_1
			pushi    0
			lofsa    invEvent
			send     4
			sag      gSel_1
			pushi    #sel_0
			pushi    0
			lofsa    invEvent
			send     4
			sag      gSel_0
			ldi      0
			sat      temp9
			pushi    #sel_148
			pushi    0
			lofsa    invEvent
			send     4
			pToa     sel_207
			bnt      code_0961
			pushi    #sel_61
			pushi    0
			lofsa    invEvent
			send     4
			not     
			bnt      code_0961
			pTos     sel_207
			pToa     sel_393
			ne?     
			bnt      code_0961
			pushi    #sel_31
			pushi    0
			lofsa    invEvent
			send     4
			push    
			ldi      1
			eq?     
			bt       code_0937
			pushi    #sel_31
			pushi    0
			lofsa    invEvent
			send     4
			push    
			ldi      4
			eq?     
			bnt      code_0922
			pushi    #sel_37
			pushi    0
			lofsa    invEvent
			send     4
			push    
			ldi      13
			eq?     
			bnt      code_0922
			ldi      1
			sat      temp9
			bt       code_0937
code_0922:
			pushi    #sel_31
			pushi    0
			lofsa    invEvent
			send     4
			push    
			ldi      256
			eq?     
			bnt      code_0961
			ldi      1
			sat      temp9
			bnt      code_0961
code_0937:
			pTos     sel_207
			pToa     sel_227
			ne?     
			bt       code_094b
			pushi    #sel_14
			pushi    0
			pToa     sel_227
			send     4
			push    
			ldi      16
			and     
			bnt      code_0961
code_094b:
			pushi    #sel_31
			pushi    1
			pushi    16384
			pushi    37
			pushi    1
			pushi    #sel_37
			pushi    0
			pToa     sel_207
			send     4
			push    
			lofsa    invEvent
			send     12
code_0961:
			pushi    1
			lofsa    invEvent
			push    
			callk    MapKeyToDir,  2
			pushi    #sel_31
			pushi    0
			lofsa    invEvent
			send     4
			sat      temp2
			lag      gEventHandlerSel_109
			bnt      code_0986
			pushi    #sel_133
			pushi    1
			lofsa    invEvent
			push    
			lag      gEventHandlerSel_109
			send     6
			jmp      code_0cff
code_0986:
			lst      temp2
			ldi      1
			eq?     
			bnt      code_09a9
			pushi    #sel_61
			pushi    0
			lofsa    invEvent
			send     4
			bnt      code_09a9
			pushi    #sel_231
			pushi    0
			self     4
			pushi    #sel_73
			pushi    1
			pushi    1
			lofsa    invEvent
			send     6
			jmp      code_0cff
code_09a9:
			lst      temp2
			ldi      0
			eq?     
			bnt      code_09d1
			pushi    #sel_120
			pushi    2
			pushi    218
			lofsa    invEvent
			push    
			self     8
			sat      temp0
			bnt      code_09d1
			push    
			pToa     sel_223
			ne?     
			bnt      code_09d1
			pushi    #sel_217
			pushi    1
			lst      temp0
			self     6
			jmp      code_0cff
code_09d1:
			lst      temp2
			ldi      1
			eq?     
			bt       code_09f6
			lst      temp2
			ldi      4
			eq?     
			bnt      code_09ed
			pushi    #sel_37
			pushi    0
			lofsa    invEvent
			send     4
			push    
			ldi      13
			eq?     
			bt       code_09f6
code_09ed:
			lst      temp2
			ldi      256
			eq?     
			bnt      code_0a83
code_09f6:
			pushi    1
			pTos     sel_223
			callk    IsObject,  2
			bnt      code_0cff
			pushi    178
			pushi    #sel_2
			pTos     sel_223
			lst      temp2
			ldi      1
			eq?     
			push    
			self     8
			bnt      code_0cff
			pTos     sel_223
			pToa     sel_392
			eq?     
			bnt      code_0a1d
			jmp      code_0d0a
			jmp      code_0cff
code_0a1d:
			pTos     sel_223
			pToa     sel_227
			eq?     
			bnt      code_0a6c
			pushi    #sel_33
			pushi    0
			pToa     sel_223
			send     4
			push    
			ldi      65535
			ne?     
			bnt      code_0a42
			pushi    #sel_197
			pushi    1
			pushi    #sel_33
			pushi    0
			pToa     sel_227
			send     4
			push    
			lag      gGame
			send     6
code_0a42:
			pTos     sel_29
			ldi      2048
			and     
			bnt      code_0a53
			pushi    #sel_234
			pushi    0
			self     4
			jmp      code_0cff
code_0a53:
			pToa     sel_227
			bnt      code_0cff
			pushi    14
			pushi    #sel_1
			pushi    #sel_14
			pushi    0
			send     4
			push    
			ldi      16
			or      
			push    
			pToa     sel_227
			send     6
			jmp      code_0cff
code_0a6c:
			pToa     sel_223
			aTop     sel_207
			pushi    #sel_197
			pushi    1
			pushi    #sel_33
			pushi    0
			pToa     sel_207
			send     4
			push    
			lag      gGame
			send     6
			jmp      code_0cff
code_0a83:
			lst      temp2
			ldi      64
			and     
			bnt      code_0b3b
			pushi    #sel_37
			pushi    0
			lofsa    invEvent
			send     4
			push    
			dup     
			ldi      3
			eq?     
			bnt      code_0aa3
			pushi    #sel_190
			pushi    0
			self     4
			jmp      code_0b37
code_0aa3:
			dup     
			ldi      7
			eq?     
			bnt      code_0ab2
			pushi    #sel_191
			pushi    0
			self     4
			jmp      code_0b37
code_0ab2:
			dup     
			ldi      1
			eq?     
			bnt      code_0ae8
			pToa     sel_223
			bnt      code_0adf
			pushi    3
			push    
			pushi    #sel_6
			pushi    0
			send     4
			push    
			ldi      1
			sub     
			push    
			pushi    0
			call     localproc_07be,  6
			sat      temp0
			bnt      code_0adf
			pushi    #sel_217
			pushi    2
			lst      temp0
			pushi    1
			self     8
			jmp      code_0b37
code_0adf:
			pushi    #sel_191
			pushi    0
			self     4
			jmp      code_0b37
code_0ae8:
			dup     
			ldi      5
			eq?     
			bnt      code_0b24
			pToa     sel_223
			bnt      code_0b1c
			pushi    3
			push    
			pushi    #sel_8
			pushi    0
			send     4
			push    
			ldi      1
			add     
			push    
			pushi    #sel_195
			pushi    0
			pToa     sel_32
			send     4
			push    
			call     localproc_07be,  6
			sat      temp0
			bnt      code_0b1c
			pushi    #sel_217
			pushi    2
			lst      temp0
			pushi    1
			self     8
			jmp      code_0b37
code_0b1c:
			pushi    #sel_190
			pushi    0
			self     4
			jmp      code_0b37
code_0b24:
			dup     
			ldi      0
			eq?     
			bnt      code_0b37
			lst      temp2
			ldi      4
			and     
			bnt      code_0b37
			pushi    #sel_231
			pushi    0
			self     4
code_0b37:
			toss    
			jmp      code_0cff
code_0b3b:
			lst      temp2
			ldi      4
			eq?     
			bnt      code_0b6b
			pushi    #sel_37
			pushi    0
			lofsa    invEvent
			send     4
			push    
			dup     
			ldi      9
			eq?     
			bnt      code_0b5a
			pushi    #sel_190
			pushi    0
			self     4
			jmp      code_0b67
code_0b5a:
			dup     
			ldi      3840
			eq?     
			bnt      code_0b67
			pushi    #sel_191
			pushi    0
			self     4
code_0b67:
			toss    
			jmp      code_0cff
code_0b6b:
			lst      temp2
			ldi      16384
			and     
			bnt      code_0cff
			pushi    #sel_120
			pushi    2
			pushi    218
			lofsa    invEvent
			push    
			self     8
			sat      temp0
			bnt      code_0cff
			lst      temp2
			ldi      8192
			and     
			bnt      code_0c29
			lat      temp0
			bnt      code_0c08
			pushi    #sel_213
			pushi    0
			send     4
			bnt      code_0c08
			pushi    7
			pushi    0
			pushi    #sel_214
			pushi    0
			lat      temp0
			send     4
			push    
			pushi    #sel_213
			pushi    0
			lat      temp0
			send     4
			push    
			pushi    #sel_215
			pushi    0
			lat      temp0
			send     4
			push    
			pushi    0
			pushi    1
			lea      @temp10
			push    
			callk    Message,  14
			bnt      code_0c08
			pushi    #sel_116
			pushi    1
			pushi    236
			lag      gLb2Win
			send     6
			bnt      code_0bfd
			pushi    #sel_236
			pushi    0
			lag      gLb2Win
			send     4
			sat      temp6
			pushi    #sel_236
			pushi    1
			pushi    1
			lag      gLb2Win
			send     6
			pushi    1
			lea      @temp10
			push    
			calle    proc921_0,  2
			pushi    #sel_236
			pushi    1
			lst      temp6
			lag      gLb2Win
			send     6
			jmp      code_0c08
code_0bfd:
			pushi    1
			lea      @temp10
			push    
			calle    proc921_0,  2
code_0c08:
			pushi    14
			pushi    #sel_1
			pushi    #sel_14
			pushi    0
			pToa     sel_227
			send     4
			push    
			ldi      65519
			and     
			push    
			pToa     sel_227
			send     6
			pushi    #sel_197
			pushi    1
			pushi    999
			lag      gGame
			send     6
			jmp      code_0cff
code_0c29:
			lst      temp0
			pToa     sel_392
			eq?     
			bnt      code_0c36
			jmp      code_0d0a
			jmp      code_0cff
code_0c36:
			pushi    #sel_114
			pushi    1
			class    InvI
			push    
			lat      temp0
			send     6
			not     
			bnt      code_0c96
			pushi    #sel_178
			pushi    2
			lst      temp0
			lat      temp9
			not     
			push    
			self     8
			bnt      code_0cff
			lat      temp0
			aTop     sel_207
			pushi    #sel_197
			pushi    1
			pushi    #sel_33
			pushi    0
			pToa     sel_207
			send     4
			push    
			lag      gGame
			send     6
			lst      temp0
			pToa     sel_227
			eq?     
			bnt      code_0cff
			pTos     sel_29
			ldi      2048
			and     
			bnt      code_0c80
			pushi    #sel_234
			pushi    0
			self     4
			jmp      code_0cff
code_0c80:
			pushi    14
			pushi    #sel_1
			pushi    #sel_14
			pushi    0
			pToa     sel_227
			send     4
			push    
			ldi      16
			or      
			push    
			pToa     sel_227
			send     6
			jmp      code_0cff
code_0c96:
			pToa     sel_207
			bnt      code_0cff
			pushi    #sel_116
			pushi    1
			pushi    236
			lag      gLb2Win
			send     6
			bnt      code_0cba
			pushi    #sel_236
			pushi    0
			lag      gLb2Win
			send     4
			sat      temp6
			pushi    #sel_236
			pushi    1
			pushi    1
			lag      gLb2Win
			send     6
code_0cba:
			pushi    #sel_114
			pushi    1
			class    InvI
			push    
			pToa     sel_207
			send     6
			bnt      code_0cd8
			pushi    #sel_300
			pushi    1
			pushi    #sel_37
			pushi    0
			pToa     sel_207
			send     4
			push    
			lat      temp0
			send     6
			jmp      code_0ce9
code_0cd8:
			pushi    #sel_300
			pushi    1
			pushi    #sel_37
			pushi    0
			lofsa    invEvent
			send     4
			push    
			lat      temp0
			send     6
code_0ce9:
			pushi    #sel_116
			pushi    1
			pushi    236
			lag      gLb2Win
			send     6
			bnt      code_0cff
			pushi    #sel_236
			pushi    1
			lst      temp6
			lag      gLb2Win
			send     6
code_0cff:
			pushi    #sel_111
			pushi    0
			lofsa    invEvent
			send     4
			jmp      code_0887
code_0d0a:
			pushi    #sel_111
			pushi    0
			lofsa    invEvent
			send     4
			pushi    #sel_116
			pushi    1
			pushi    236
			lag      gLb2Win
			send     6
			bnt      code_0d28
			pushi    #sel_236
			pushi    1
			lst      temp7
			lag      gLb2Win
			send     6
code_0d28:
			pushi    #sel_102
			pushi    0
			self     4
			ret     
		)
	)
	
	(method (sel_113 param1)
		(gSounds sel_168:)
		(if (and gPseudoMouse (gPseudoMouse sel_116: 167))
			(gPseudoMouse sel_167:)
		)
		(if (gIconBar sel_220?) (gIconBar sel_102:))
		(if (not sel_32) (= sel_32 (SysWindow sel_109:)))
		(if (sel_32 sel_32?) (sel_32 sel_111:) (= sel_32 0))
		(if (not sel_392)
			(= sel_392 (NodeValue (self sel_124:)))
		)
		(= sel_207 0)
		(if (self sel_216: (if argc param1 else gEgo))
			(self sel_57:)
		)
	)
	
	(method (sel_216 param1 &tmp temp0 temp1)
		(gGame
			sel_197: (if sel_207 (sel_207 sel_33?) else (sel_393 sel_33?))
		)
		(= temp0 (PicNotValid))
		(PicNotValid 0)
		(= sel_29 (| sel_29 $0020))
		(if
			(not
				(= temp1
					(self
						sel_394: (if argc param1 else gEgo) (gIconBar sel_207?)
					)
				)
			)
			(= sel_29 (& sel_29 $ffdf))
		)
		(PicNotValid temp0)
		(return temp1)
	)
	
	(method (sel_102 &tmp temp0)
		(if (& sel_29 $0020)
			(gSounds sel_168: 0)
			(= sel_29 (& sel_29 $ffdf))
		)
		(if sel_32 (sel_32 sel_111:))
		(if
		(and (IsObject sel_207) (sel_207 sel_114: InvI))
			(if (not (gIconBar sel_225?))
				(gIconBar sel_177: (gIconBar sel_226?))
			)
			(gIconBar
				sel_207: ((gIconBar sel_226?) sel_33: (sel_207 sel_33?) sel_117:)
				sel_225: sel_207
			)
			(if (= temp0 ((gIconBar sel_207?) sel_33?))
				(gGame sel_197: temp0)
			)
		)
	)
	
	(method (sel_190 param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1 (if argc param1 else 1))
		(= temp3 (+ temp1 (= temp2 (self sel_132: sel_223))))
		(repeat
			(= temp0
				(self
					sel_64: (if (<= temp3 sel_86)
						temp3
					else
						(mod temp3 (- sel_86 1))
					)
				)
			)
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self sel_124:)))
			)
			(if (not (& (temp0 sel_14?) $0004)) (break))
			(++ temp3)
		)
		(self sel_217: temp0 1)
	)
	
	(method (sel_191 param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1 (if argc param1 else 1))
		(= temp3 (- (= temp2 (self sel_132: sel_223)) temp1))
		(repeat
			(= temp0 (self sel_64: temp3))
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self sel_127:)))
			)
			(if (not (& (temp0 sel_14?) $0004)) (break))
			(-- temp3)
		)
		(self sel_217: temp0 1)
	)
	
	(method (sel_353 param1)
		(self sel_120: 353 param1)
	)
	
	(method (sel_394 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 invSel_124 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 invSel_32 [temp22 50])
		(= temp0
			(= temp1 (= temp2 (= temp3 (= temp4 (= temp5 0)))))
		)
		(= invSel_124 (self sel_124:))
		(while invSel_124
			(if
			((= temp9 (NodeValue invSel_124)) sel_114: InvI)
				(if (temp9 sel_353: param1)
					(temp9 sel_14: (& (temp9 sel_14?) $fffb))
					(++ temp0)
					(if
						(>
							(= temp6
								(CelWide (temp9 sel_2?) (temp9 sel_3?) (temp9 sel_4?))
							)
							temp2
						)
						(= temp2 temp6)
					)
					(if
						(>
							(= temp7
								(CelHigh (temp9 sel_2?) (temp9 sel_3?) (temp9 sel_4?))
							)
							temp1
						)
						(= temp1 temp7)
					)
				else
					(temp9 sel_14: (| (temp9 sel_14?) $0004))
				)
			else
				(++ temp3)
				(= temp5
					(+
						temp5
						(CelWide (temp9 sel_2?) (temp9 sel_3?) (temp9 sel_4?))
					)
				)
				(if
					(>
						(= temp7
							(CelHigh (temp9 sel_2?) (temp9 sel_3?) (temp9 sel_4?))
						)
						temp4
					)
					(= temp4 temp7)
				)
			)
			(= invSel_124 (self sel_65: invSel_124))
		)
		(if (not temp0)
			(Print sel_199: @temp22 {%s %s} sel_389 sel_390 sel_110:)
			(return 0)
		)
		(if (> (* (= temp16 (Sqrt temp0)) temp16) temp0)
			(-- temp16)
		)
		(if (> temp16 3) (= temp16 3))
		(if
		(< (* temp16 (= local0 (/ temp0 temp16))) temp0)
			(++ local0)
		)
		(= temp10
			(proc999_3 (+ 4 temp5) (* local0 (+ 4 temp2)))
		)
		(= temp12
			(/ (- 190 (= temp11 (* temp16 (+ 4 temp1)))) 2)
		)
		(= temp13 (/ (- 320 temp10) 2))
		(= temp14 (+ temp12 temp11))
		(= temp15 (+ temp13 temp10))
		(if (= invSel_32 (self sel_32?))
			(invSel_32
				sel_193: temp12
				sel_194: temp13
				sel_196: temp15
				sel_195: temp14
				sel_189:
			)
		)
		(= temp20 local0)
		(if temp0
			(= temp18
				(+
					2
					(if (invSel_32 sel_116: 385)
						(invSel_32 sel_385?)
					else
						0
					)
				)
			)
			(= temp19
				(= temp17
					(+
						4
						(if (invSel_32 sel_116: 384)
							(invSel_32 sel_384?)
						else
							0
						)
					)
				)
			)
			(= invSel_124 (self sel_124:))
			(while invSel_124
				(if
					(and
						(not
							(& ((= temp9 (NodeValue invSel_124)) sel_14?) $0004)
						)
						(temp9 sel_114: InvI)
					)
					(if (not (& (temp9 sel_14?) $0080))
						(temp9
							sel_7:
								(+
									temp17
									(/
										(-
											temp2
											(= temp6
												(CelWide (temp9 sel_2?) (temp9 sel_3?) (temp9 sel_4?))
											)
										)
										2
									)
								)
							sel_6:
								(+
									temp18
									(/
										(-
											temp1
											(= temp7
												(CelHigh (temp9 sel_2?) (temp9 sel_3?) (temp9 sel_4?))
											)
										)
										2
									)
								)
						)
						(temp9
							sel_9: (+ (temp9 sel_7?) temp6)
							sel_8: (+ (temp9 sel_6?) temp7)
						)
						(if (-- temp20)
							(= temp17 (+ temp17 temp2))
						else
							(= temp20 local0)
							(= temp18 (+ temp18 temp1))
							(= temp17 temp19)
						)
					else
						(= temp17 (temp9 sel_7?))
						(= temp18 (temp9 sel_6?))
					)
					(temp9 sel_216:)
					(if (== temp9 param2) (temp9 sel_217:))
				)
				(= invSel_124 (self sel_65: invSel_124))
			)
		)
		(= temp17
			(/
				(- (- (invSel_32 sel_196?) (invSel_32 sel_194?)) temp5)
				2
			)
		)
		(= temp11
			(- (invSel_32 sel_195?) (invSel_32 sel_193?))
		)
		(= temp18 32767)
		(= invSel_124 (self sel_124:))
		(while invSel_124
			(if
			(not ((= temp9 (NodeValue invSel_124)) sel_114: InvI))
				(= temp6
					(CelWide (temp9 sel_2?) (temp9 sel_3?) (temp9 sel_4?))
				)
				(= temp7
					(CelHigh (temp9 sel_2?) (temp9 sel_3?) (temp9 sel_4?))
				)
				(if (not (& (temp9 sel_14?) $0080))
					(if (== temp18 32767) (= temp18 (- temp11 temp7)))
					(temp9
						sel_7: temp17
						sel_6: temp18
						sel_8: temp11
						sel_9: (+ temp17 temp6)
					)
				)
				(= temp17 (+ (temp9 sel_7?) temp6))
				(= temp18 (temp9 sel_6?))
				(temp9 sel_14: (& (temp9 sel_14?) $fffb) sel_216:)
			)
			(= invSel_124 (self sel_65: invSel_124))
		)
		(return 1)
	)
)

(instance invEvent of Event
	(properties
		sel_20 {invEvent}
	)
)
