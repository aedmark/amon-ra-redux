;;; Sierra Script 1.0 - (do not remove this comment)
(script# 560)
(include sci.sh)
(use Main)
(use Door)
(use LBRoom)
(use Inset)
(use Scaler)
(use PolyPath)
(use CueObj)
(use n958)
(use Timer)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm560 0
	westDoor 4
)

(local
	local0
	local1
	local2
)
(instance rm560 of LBRoom
	(properties
		sel_20 {rm560}
		sel_408 560
		sel_409 666
		sel_412 550
		sel_107 0
	)
	
	(method (sel_110)
		(proc958_0 128 560 561 562 563 564 814 831)
		(proc958_0 132 560 561 558 562 564 566 565 44 45 721 567)
		(gEgo
			sel_110:
			sel_585: 831
			sel_316:
			sel_320: Scaler 130 0 190 0
		)
		(self sel_414: 90)
		(switch gGSel_40
			(sel_409
				(global2 sel_146: sEnterTunnel)
			)
			(sel_412
				(gEgo sel_349: 0 sel_253: 270)
				(if (proc999_5 global111 1 7)
					(++ global111)
					(westDoor sel_590: 1)
					(waterPrompt sel_162: waterPrompt 5)
				)
				(if
					(or
						(> global123 3)
						(and (== global123 3) (proc0_10 -15612 1))
					)
					(proc0_5 gEgo deadWatney)
					(gGame sel_87: 1 171)
				)
			)
			(565 0 (gGame sel_588:))
			(else 
				(gEgo sel_153: 20 180)
				(gGame sel_588:)
			)
		)
		(super sel_110:)
		(if (== gGSel_40 sel_409)
			(Palette palSET_INTENSITY 0 255 100)
		)
		(gGameMusic2 sel_40: 565 sel_3: -1 sel_99: 1 sel_39:)
		(if
			(or
				(> global123 3)
				(and (== global123 3) (proc0_10 -15612 1))
			)
			(deskClock sel_317:)
			(deadWatney sel_317:)
		else
			(deskClock sel_317: sel_156: 4)
			(porcupine sel_317: sel_311: 4 1 8)
		)
		(calendar sel_317: sel_311: 4 1 8)
		(intercom sel_317: sel_311: 4 1 8)
		(phoneList sel_317: sel_311: 4 1 8)
		(phone sel_317: sel_311: 4 1 8)
		(safePic sel_110: sel_313: sel_311: 4 1 8)
		(westDoor sel_110:)
		(if (!= gGSel_40 sel_409)
			(secretDoor sel_110: sel_313:)
		)
		(genericMask sel_110:)
		(pillars sel_110:)
		(desk sel_110: sel_311: 1)
		(drawers sel_110:)
		(deskLamp sel_110:)
		(chair sel_110:)
		(rug sel_110:)
		(fireplaceOut sel_110:)
		(fireplaceIn sel_110: sel_311: 4 1 8)
		(bookcase sel_110:)
		(genericBookshelf sel_110:)
		(book sel_110: sel_311: 4 1 8)
		(bigPainting sel_110:)
		(genericStars sel_110:)
		(skylightBase sel_110:)
		(skylightSupport sel_110:)
		(nightSky sel_110:)
		(buildingBig sel_110:)
		(buildingPointed sel_110:)
		(if
			(and
				(== gGSel_40 565)
				(== global123 3)
				(not (proc0_10 -15612))
			)
			((ScriptID 22 0) sel_57: -15612)
			((ScriptID 90 1) sel_619: 0 sel_620: -1)
		)
	)
	
	(method (sel_57)
		(super sel_57:)
		(if
			(and
				local0
				(!= (gEgo sel_1?) 93)
				(!= (gEgo sel_0?) 149)
				(!= ((ScriptID 32 0) sel_620?) gSel_40)
			)
			(= local0 0)
			(self sel_146: sDumpSafe)
		)
	)
	
	(method (sel_111)
		(proc958_0 0 561 562)
		(gGameMusic2 sel_170:)
		(super sel_111: &rest)
	)
)

(instance westDoor of Door
	(properties
		sel_20 {westDoor}
		sel_1 17
		sel_0 148
		sel_213 36
		sel_301 40
		sel_303 14
		sel_304 160
		sel_2 560
		sel_3 1
		sel_60 7
		sel_14 16
		sel_589 550
		sel_593 38
		sel_597 4
		sel_598 145
		sel_599 0
		sel_600 0
	)
	
	(method (sel_110)
		(super sel_110:)
		(self sel_311: 4 38)
	)
	
	(method (sel_605)
		(switch global111
			(2
				(gLb2Messager sel_295: 1 38 1 0 0 1560)
				(++ global111)
				(= sel_590 0)
			)
			(8
				(gLb2Messager sel_295: 1 38 2 0 0 1560)
				(++ global111)
				(= sel_590 0)
			)
			(else  (super sel_605: &rest))
		)
	)
	
	(method (sel_606)
		(super sel_606: 0 142 23 136 31 147 0 153)
	)
)

(instance secretDoor of Prop
	(properties
		sel_20 {secretDoor}
		sel_1 294
		sel_0 147
		sel_2 560
		sel_3 2
		sel_244 12
	)
)

(instance safePic of View
	(properties
		sel_20 {safePic}
		sel_1 82
		sel_0 100
		sel_213 77
		sel_303 93
		sel_304 149
		sel_2 564
		sel_3 1
		sel_60 6
		sel_14 16
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(proc0_5 gEgo safePic)
				((ScriptID 561 0) sel_110:)
				(= local0 1)
				(self sel_102:)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance deadWatney of View
	(properties
		sel_20 {deadWatney}
		sel_1 137
		sel_0 114
		sel_2 560
		sel_60 11
		sel_14 16400
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(gGame sel_587:)
				(proc0_5 gEgo deadWatney)
				(global2 sel_399: 565)
			)
			(8
				(gGame sel_587:)
				(proc0_5 gEgo deadWatney)
				(global2 sel_399: 565)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance porcupine of View
	(properties
		sel_20 {porcupine}
		sel_1 131
		sel_0 112
		sel_213 37
		sel_303 162
		sel_304 170
		sel_2 560
		sel_4 1
		sel_60 12
		sel_14 16
	)
)

(instance deskClock of View
	(properties
		sel_20 {deskClock}
		sel_1 128
		sel_0 114
		sel_213 41
		sel_303 89
		sel_304 185
		sel_2 563
		sel_3 4
		sel_4 5
		sel_60 11
		sel_14 16
	)
	
	(method (sel_300 param1)
		(switch param1
			(1 (global2 sel_422: inClock))
			(8 (global2 sel_422: inClock))
			(else  (super sel_300: param1))
		)
	)
)

(instance intercom of View
	(properties
		sel_20 {intercom}
		sel_1 132
		sel_0 122
		sel_213 42
		sel_303 93
		sel_304 171
		sel_2 563
		sel_3 4
		sel_4 3
		sel_60 12
		sel_14 16
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(global2 sel_422: (ScriptID 562 0))
			)
			(8
				(global2 sel_422: (ScriptID 562 0))
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance phone of View
	(properties
		sel_20 {phone}
		sel_1 83
		sel_0 118
		sel_213 58
		sel_303 62
		sel_304 181
		sel_2 563
		sel_3 4
		sel_4 6
		sel_60 12
		sel_14 16
	)
	
	(method (sel_300 param1)
		(switch param1
			(1 (global2 sel_422: inPhone))
			(8 (global2 sel_422: inPhone))
			(else  (super sel_300: param1))
		)
	)
)

(instance phoneList of View
	(properties
		sel_20 {phoneList}
		sel_1 109
		sel_0 123
		sel_213 43
		sel_303 77
		sel_304 178
		sel_2 563
		sel_3 4
		sel_60 12
		sel_14 16
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(global2 sel_422: inPhonelist)
			)
			(8
				(global2 sel_422: inPhonelist)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance calendar of View
	(properties
		sel_20 {calendar}
		sel_1 120
		sel_0 118
		sel_213 44
		sel_303 99
		sel_304 178
		sel_2 563
		sel_3 4
		sel_4 1
		sel_60 12
		sel_14 16
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(++ local2)
				(global2 sel_422: inCalendar)
			)
			(8
				(++ local2)
				(global2 sel_422: inCalendar)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance genericMask of Feature
	(properties
		sel_20 {genericMask}
		sel_0 2
	)
	
	(method (sel_218 param1)
		(if (super sel_218: param1)
			(cond 
				(
					(and
						(<= 34 gSel_1)
						(<= gSel_1 50)
						(<= 63 gSel_0)
						(<= gSel_0 87)
					)
					(= sel_213 4)
				)
				(
					(and
						(<= 34 gSel_1)
						(<= gSel_1 50)
						(<= 94 gSel_0)
						(<= gSel_0 126)
					)
					(= sel_213 5)
				)
				(
					(and
						(<= 265 gSel_1)
						(<= gSel_1 282)
						(<= 71 gSel_0)
						(<= gSel_0 97)
					)
					(= sel_213 6)
				)
				(
					(and
						(<= 265 gSel_1)
						(<= gSel_1 281)
						(<= 101 gSel_0)
						(<= gSel_0 127)
					)
					(= sel_213 7)
				)
			)
		)
	)
)

(instance pillars of Feature
	(properties
		sel_20 {pillars}
		sel_0 1
		sel_213 8
		sel_302 8
	)
)

(instance desk of Feature
	(properties
		sel_20 {desk}
		sel_0 117
		sel_213 9
		sel_302 2048
		sel_303 114
		sel_304 171
	)
)

(instance drawers of Feature
	(properties
		sel_20 {drawers}
		sel_0 1
		sel_213 10
		sel_302 8192
	)
)

(instance deskLamp of Feature
	(properties
		sel_20 {deskLamp}
		sel_0 1
		sel_213 11
		sel_302 4096
	)
)

(instance chair of Feature
	(properties
		sel_20 {chair}
		sel_0 1
		sel_213 12
		sel_302 16384
	)
)

(instance rug of Feature
	(properties
		sel_20 {rug}
		sel_0 1
		sel_213 13
		sel_302 1024
	)
)

(instance fireplaceOut of Feature
	(properties
		sel_20 {fireplaceOut}
		sel_0 1
		sel_213 14
		sel_302 512
	)
)

(instance fireplaceIn of Feature
	(properties
		sel_20 {fireplaceIn}
		sel_0 1
		sel_213 15
		sel_302 256
		sel_303 78
		sel_304 145
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if (or (gEgo sel_238: 33) (proc0_2 35))
					(gLb2Messager sel_295: 15 1)
				else
					(global2 sel_422: inCharcoal)
				)
			)
			(4
				(if (or (gEgo sel_238: 33) (proc0_2 35))
					(gLb2Messager sel_295: 15 4 10)
				else
					(gLb2Messager sel_295: 15 4 11)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance bookcase of Feature
	(properties
		sel_20 {bookcase}
		sel_0 1
		sel_213 16
		sel_302 16
	)

	(method (sel_300 param1)
		(if
			(and
				(not (gEgo sel_238: 24))
				(proc999_5 param1 1 4 8)
			)
			(global2 sel_146: sGetBook)
		else
			(super sel_300: param1 &rest)
		)
	)
)

(instance genericBookshelf of Feature
	(properties
		sel_20 {genericBookshelf}
		sel_0 2
		sel_303 184
		sel_304 169
	)
	
	(method (sel_218 param1)
		(if (super sel_218: param1)
			(cond 
				(
					(and
						(<= 185 gSel_1)
						(<= gSel_1 201)
						(<= 80 gSel_0)
						(<= gSel_0 92)
					)
					(= sel_213 17)
				)
				(
					(and
						(<= 203 gSel_1)
						(<= gSel_1 241)
						(<= 75 gSel_0)
						(<= gSel_0 89)
					)
					(= sel_213 18)
				)
				(
					(and
						(<= 184 gSel_1)
						(<= gSel_1 201)
						(<= 94 gSel_0)
						(<= gSel_0 107)
					)
					(= sel_213 19)
				)
				(
					(and
						(<= 203 gSel_1)
						(<= gSel_1 240)
						(<= 90 gSel_0)
						(<= gSel_0 106)
					)
					(= sel_213 20)
				)
				(
					(and
						(<= 203 gSel_1)
						(<= gSel_1 239)
						(<= 108 gSel_0)
						(<= gSel_0 120)
					)
					(= sel_213 21)
				)
			)
		)
	)
)

(instance book of Feature
	(properties
		sel_20 {book}
		sel_1 221
		sel_0 115
		sel_55 90
		sel_213 22
		sel_6 84
		sel_7 212
		sel_8 122
		sel_9 248
		sel_302 64
		sel_303 214
		sel_304 155
	)
	
	(method (sel_300 param1)
		(switch param1
			(4 (global2 sel_146: sGetBook))
			(else  (super sel_300: param1))
		)
	)
)

(instance bigPainting of Feature
	(properties
		sel_20 {bigPainting}
		sel_1 154
		sel_0 99
		sel_213 23
		sel_6 86
		sel_7 135
		sel_8 113
		sel_9 174
	)
)

(instance genericStars of Feature
	(properties
		sel_20 {genericStars}
		sel_0 20
	)
	
	(method (sel_218 param1)
		(return
			(if
				(and
					(<= 113 gSel_1)
					(<= gSel_1 216)
					(<= 4 gSel_0)
					(<= gSel_0 41)
				)
				(if
				(& (OnControl 4 (param1 sel_1?) (param1 sel_0?)) $1000)
					(= sel_213 24)
					(return 1)
				)
				(if
				(& (OnControl 4 (param1 sel_1?) (param1 sel_0?)) $2000)
					(= sel_213 25)
					(return 1)
				)
				(if
				(& (OnControl 4 (param1 sel_1?) (param1 sel_0?)) $8000)
					(= sel_213 26)
					(return 1)
				)
				(if
				(& (OnControl 4 (param1 sel_1?) (param1 sel_0?)) $4000)
					(= sel_213 27)
					(return 1)
				)
				(if
				(& (OnControl 4 (param1 sel_1?) (param1 sel_0?)) $0800)
					(= sel_213 28)
					(return 1)
				)
				(if
				(& (OnControl 4 (param1 sel_1?) (param1 sel_0?)) $0400)
					(= sel_213 29)
					(return 1)
				)
				(if
				(& (OnControl 4 (param1 sel_1?) (param1 sel_0?)) $0200)
					(= sel_213 30)
					(return 1)
				)
			else
				0
			)
		)
	)
)

(instance skylightBase of Feature
	(properties
		sel_20 {skylightBase}
		sel_1 161
		sel_0 36
		sel_213 31
		sel_6 1
		sel_7 50
		sel_8 72
		sel_9 272
		sel_302 16
	)
)

(instance skylightSupport of Feature
	(properties
		sel_20 {skylightSupport}
		sel_1 161
		sel_0 36
		sel_213 32
		sel_6 1
		sel_7 50
		sel_8 72
		sel_9 272
		sel_302 64
	)
)

(instance nightSky of Feature
	(properties
		sel_20 {nightSky}
		sel_1 161
		sel_0 36
		sel_213 33
		sel_6 1
		sel_7 50
		sel_8 72
		sel_9 272
		sel_302 32
	)
)

(instance buildingBig of Feature
	(properties
		sel_20 {buildingBig}
		sel_1 161
		sel_0 36
		sel_213 34
		sel_6 1
		sel_7 50
		sel_8 72
		sel_9 272
		sel_302 256
	)
)

(instance buildingPointed of Feature
	(properties
		sel_20 {buildingPointed}
		sel_1 161
		sel_0 36
		sel_213 35
		sel_6 1
		sel_7 50
		sel_8 72
		sel_9 272
		sel_302 128
	)
)

(instance inBookClosed of Inset
	(properties
		sel_20 {inBookClosed}
		sel_2 562
		sel_1 216
		sel_0 69
		sel_570 1
		sel_213 47
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(global2 sel_422: inBookOpen)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance inBookOpen of Inset
	(properties
		sel_20 {inBookOpen}
		sel_2 562
		sel_3 1
		sel_1 216
		sel_0 69
		sel_60 13
		sel_570 1
		sel_213 48
	)
	
	(method (sel_110)
		(super sel_110: &rest)
		(if (not (gEgo sel_238: 24)) (file sel_110:))
	)
	
	(method (sel_111)
		(if (IsObject file) (file sel_111: sel_81:))
		(super sel_111:)
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if (gEgo sel_238: 24)
					(gLb2Messager sel_295: sel_213 1 9)
				else
					(gGame sel_87: 0 183)
					((ScriptID 21 0) sel_57: 793)
					((ScriptID 21 0) sel_57: 272)
					(gLb2Messager sel_295: sel_213 1 8)
				)
			)
			(8
				(if (gEgo sel_238: 24)
					(gLb2Messager sel_295: sel_213 8 9)
				else
					(gLb2Messager sel_295: sel_213 8 8)
				)
			)
			(4
				(if (gEgo sel_238: 24)
					(gLb2Messager sel_295: sel_213 4 9)
				else
					(gEgo sel_350: 24)
					(gGame sel_87: 0 183)
					((ScriptID 21 0) sel_57: 793)
					((ScriptID 21 0) sel_57: 272)
					(gGame sel_87: 1 172)
					(file sel_111:)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance file of View
	(properties
		sel_20 {file}
		sel_1 218
		sel_0 71
		sel_2 562
		sel_3 1
		sel_4 1
		sel_60 14
		sel_14 16
	)
	
	(method (sel_300 param1)
		(inBookOpen sel_300: param1 &rest)
	)
)

(instance inCharcoal of Inset
	(properties
		sel_20 {inCharcoal}
		sel_2 563
		sel_4 3
		sel_1 21
		sel_0 124
		sel_570 1
		sel_213 45
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(global2 sel_146: sGetCoal)
				(self sel_111:)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance inClock of Inset
	(properties
		sel_20 {inClock}
		sel_2 563
		sel_1 101
		sel_0 105
		sel_570 1
		sel_213 52
	)
	
	(method (sel_110)
		(if (proc0_2 3) (self sel_4: 1 sel_213: 53))
		(super sel_110: &rest)
	)
)

(instance inPhone of Inset
	(properties
		sel_20 {inPhone}
		sel_2 563
		sel_3 3
		sel_4 3
		sel_1 79
		sel_0 99
		sel_570 1
		sel_213 59
	)
)

(instance inPhonelist of Inset
	(properties
		sel_20 {inPhonelist}
		sel_2 563
		sel_3 2
		sel_1 87
		sel_0 93
		sel_570 1
		sel_213 49
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(global2 sel_422: inPhoneOpen)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance inPhoneOpen of Inset
	(properties
		sel_20 {inPhoneOpen}
		sel_2 563
		sel_3 2
		sel_4 1
		sel_1 87
		sel_0 93
		sel_570 1
		sel_213 50
	)
	
	(method (sel_300 param1)
		(switch param1
			(1 (gLb2Messager sel_295: 50 1))
			(8
				(if local2
					(gLb2Messager sel_295: sel_213 param1 6)
				else
					(gLb2Messager sel_295: sel_213 param1 7)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance inCalendar of Inset
	(properties
		sel_20 {inCalendar}
		sel_2 563
		sel_4 4
		sel_1 108
		sel_0 99
		sel_570 1
		sel_213 51
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(gGame sel_87: 1 173)
				(gLb2Messager sel_295: 51 1)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance sGetCoal of Script
	(properties
		sel_20 {sGetCoal}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_585: 831 sel_312: PolyPath 79 143 self)
			)
			(1
				(gEgo
					sel_2: 561
					sel_155: 1
					sel_4: 0
					sel_153: 78 141
					sel_244: 12
					sel_161: End self
				)
			)
			(2
				(sFX sel_40: 564 sel_99: 1 sel_3: 1 sel_39:)
				(gGame sel_87: 1 175)
				(= sel_136 3)
			)
			(3 (gEgo sel_161: Beg self))
			(4
				(gEgo sel_585: 831 sel_3: 1 sel_153: 79 143)
				(= sel_136 1)
			)
			(5
				(gEgo sel_350: 33)
				((ScriptID 21 0) sel_57: 802)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sGetBook of Script
	(properties
		sel_20 {sGetBook}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_585: 831 sel_312: PolyPath 214 155 self)
			)
			(1
				(gEgo sel_253: 90)
				(= sel_136 1)
			)
			(2
				(gEgo
					sel_2: 561
					sel_155: 0
					sel_4: 0
					sel_153: 218 153
					sel_244: 12
					sel_161: End self
				)
			)
			(3 (= sel_139 30))
			(4
				(sFX sel_40: 566 sel_99: 5 sel_3: 1 sel_39:)
				(gEgo sel_161: Beg self)
			)
			(5 (= sel_139 60))
			(6
				(global2 sel_422: inBookClosed)
				(gEgo sel_585: 831 sel_3: 0 sel_153: 214 155)
				(= sel_136 1)
			)
			(7
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sDumpSafe of Script
	(properties
		sel_20 {sDumpSafe}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(if
					(==
						((ScriptID 561 1) sel_4?)
						((ScriptID 561 1) sel_246:)
					)
					(gGame sel_587:)
					((ScriptID 561 1) sel_63: 5 sel_161: Beg self)
					(= local1 1)
				else
					(= sel_136 1)
				)
			)
			(1
				(if local1
					(sFX sel_40: 561 sel_99: 5 sel_3: 1 sel_39:)
					(= local1 0)
					(= sel_139 60)
				else
					(= sel_136 1)
				)
			)
			(2
				(if (!= ((ScriptID 561 0) sel_4?) 0)
					((ScriptID 561 0) sel_161: Beg self)
					(sFX sel_40: 45 sel_99: 5 sel_3: 1 sel_39:)
				else
					(= sel_136 1)
				)
			)
			(3
				(safePic sel_216:)
				((ScriptID 561 0) sel_111:)
				(= sel_136 2)
			)
			(4
				(DisposeScript 561)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sEnterTunnel of Script
	(properties
		sel_20 {sEnterTunnel}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(secretDoor sel_110:)
				(= sel_136 2)
			)
			(1 (= sel_137 3))
			(2
				(gEgo sel_1: 306 sel_0: 147 sel_63: 5 sel_253: 180)
				(sFX sel_40: 721 sel_99: 5 sel_3: 1 sel_39:)
				(secretDoor sel_161: End self)
			)
			(3
				(sFX sel_167:)
				(gEgo sel_63: -1 sel_312: MoveTo 303 177 self)
			)
			(4
				(sFX sel_40: 721 sel_99: 5 sel_3: 1 sel_39:)
				(secretDoor sel_161: Beg self)
			)
			(5
				(secretDoor sel_313:)
				(sFX sel_167:)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance waterPrompt of Timer
	(properties
		sel_20 {waterPrompt}
	)
	
	(method (sel_145)
		(gLb2Messager sel_295: 79)
	)
)

(instance sFX of Sound
	(properties
		sel_20 {sFX}
		sel_99 1
	)
)
