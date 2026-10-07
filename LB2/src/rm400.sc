;;; Sierra Script 1.0 - (do not remove this comment)
(script# 400)
(include sci.sh)
(use Main)
(use LBRoom)
(use ExitFeature)
(use Inset)
(use Scaler)
(use PolyPath)
(use CueObj)
(use StopWalk)
(use Cycle)
(use View)
(use Obj)

(public
	rm400 0
)

(instance rm400 of LBRoom
	(properties
		sel_20 {rm400}
		sel_213 28
		sel_408 400
		sel_412 370
		sel_108 50
	)
	
	(method (sel_110 &tmp [temp0 30])
		(self sel_414: 93)
		((ScriptID 2400 0) sel_57: (= sel_259 (List sel_109:)))
		(gEgo
			sel_0: 180
			sel_110:
			sel_585: 831
			sel_320: Scaler 125 30 190 50
		)
		(super sel_110:)
		(cond 
			(
			(or (> global123 2) (not (& $7204 global124))) (realDagger sel_110: sel_311: 4 1 8))
			((not (proc0_2 71))
				((ScriptID 93 3)
					sel_110:
					sel_153: 70 185
					sel_155: 8
					sel_156: 1
					sel_320: 160
				)
				(sel_142 sel_65: sHeimlichShoos2)
			)
			(else (daggerGone sel_110:))
		)
		(westExitFeature sel_110:)
		(cashRegister sel_110: sel_311: 4)
		(middleShelves sel_110:)
		(secondShelf sel_110: sel_311: 4 1)
		(glassCounter sel_110:)
		(fakeDaggers sel_110: sel_311: 4 1 8)
		(footedPot sel_110: sel_311: 4 1 8)
		(largePicture sel_110: sel_311: 1)
		(littleThings sel_110: sel_311: 1)
		(leftShelves sel_110:)
		(nefertiti sel_110: sel_311: 4 1 8)
		(fakeNefertiti sel_110: sel_311: 4 1 8)
		(purplePots sel_110: sel_311: 1)
		(rug sel_110:)
		(rightShelves sel_110: sel_311: 4 1)
		(smallPicture sel_110: sel_311: 1)
	)
	
	(method (sel_111)
		(DisposeScript 2400)
		(super sel_111:)
	)
	
	(method (sel_399)
		(gGameMusic2 sel_167:)
		(gSel_608 sel_168: 0 sel_170: 127 5 5 0)
		(super sel_399: &rest)
	)
)

(instance sHeimlichShoos of Script
	(properties
		sel_20 {sHeimlichShoos}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_136 1))
			(1
				(gGame sel_587:)
				(= sel_139 30)
			)
			(2
				((ScriptID 22 0) sel_57: 29188 self)
			)
			(3
				(gSel_608 sel_168: 1)
				(gGameMusic2 sel_40: 19 sel_99: 1 sel_155: 1 sel_39:)
				((ScriptID 93 3)
					sel_110:
					sel_161: StopWalk -1
					sel_320: 160
					sel_153: -20 185
					sel_312: MoveTo 80 185 self
				)
			)
			(4
				((ScriptID 93 3) sel_155: 8 sel_156: 6)
				(= sel_139 30)
			)
			(5
				(gLb2Messager sel_295: 33 8 0 0 self)
			)
			(6
				(gEgo sel_312: PolyPath 80 165 self)
			)
			(7
				((ScriptID 93 3) sel_156: 3)
				(gEgo sel_312: PolyPath 40 180 self)
			)
			(8
				((ScriptID 93 3) sel_156: 7)
				(gEgo sel_312: PolyPath -50 180 self)
			)
			(9
				(gEgo sel_349: 4)
				(global2 sel_399: 370)
			)
		)
	)
)

(instance sHeimlichShoos2 of Script
	(properties
		sel_20 {sHeimlichShoos2}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gSel_608 sel_168: 1)
				(gGameMusic2 sel_40: 19 sel_99: 1 sel_155: 1 sel_39:)
				(= sel_136 2)
			)
			(1
				(gLb2Messager sel_295: 3 0 82 0 self 1889)
			)
			(2
				(gEgo sel_312: PolyPath -50 (gEgo sel_0?) self)
			)
			(3 (global2 sel_399: 370))
		)
	)
)

(instance daggerGone of View
	(properties
		sel_20 {daggerGone}
		sel_1 242
		sel_0 110
		sel_2 403
	)
)

(instance inPittsburgh of Inset
	(properties
		sel_20 {inPittsburgh}
		sel_408 401
		sel_1 250
		sel_0 50
		sel_560 1
	)
	
	(method (sel_110)
		(super sel_110: &rest)
		(if sel_141 (stamp sel_110:))
		(daggerFeature sel_110: sel_141)
		(proc0_8 1)
	)
	
	(method (sel_111)
		(proc0_8 0)
		(daggerFeature sel_111:)
		(if (not sel_141) (global2 sel_146: sHeimlichShoos))
		(super sel_111:)
	)
	
	(method (sel_300 param1)
		(switch param1
			(13 (self sel_111:))
		)
	)
)

(instance stamp of View
	(properties
		sel_20 {stamp}
		sel_1 88
		sel_0 85
		sel_2 401
	)
	
	(method (sel_300 param1)
		(daggerFeature sel_300: param1)
	)
)

(instance daggerFeature of Feature
	(properties
		sel_20 {daggerFeature}
		sel_1 1
		sel_0 100
		sel_302 4
	)
	
	(method (sel_110 param1)
		(= sel_213 (if param1 7 else 8))
		(super sel_110: &rest)
	)
	
	(method (sel_300 param1)
		(switch param1
			(13 (inPittsburgh sel_300: 13))
			(8
				(gLb2Messager sel_295: sel_213 8)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance westExitFeature of ExitFeature
	(properties
		sel_20 {westExitFeature}
		sel_6 150
		sel_8 189
		sel_9 5
		sel_33 12
		sel_583 4
		sel_213 32
	)
)

(instance cashRegister of Feature
	(properties
		sel_20 {cashRegister}
		sel_1 225
		sel_0 140
		sel_213 9
		sel_301 40
		sel_302 16384
		sel_303 241
		sel_304 138
		sel_305 44
	)
)

(instance middleShelves of Feature
	(properties
		sel_20 {middleShelves}
		sel_1 159
		sel_0 84
		sel_213 16
		sel_6 61
		sel_7 88
		sel_8 107
		sel_9 230
		sel_301 40
		sel_303 153
		sel_304 110
		sel_305 55
	)
)

(instance secondShelf of Feature
	(properties
		sel_20 {secondShelf}
		sel_1 136
		sel_0 85
		sel_213 2
		sel_6 79
		sel_7 101
		sel_8 91
		sel_9 171
		sel_301 40
		sel_303 136
		sel_304 110
		sel_305 34
	)
)

(instance glassCounter of Feature
	(properties
		sel_20 {glassCounter}
		sel_1 225
		sel_0 122
		sel_213 6
		sel_301 40
		sel_302 8192
		sel_303 222
		sel_304 140
	)
)

(instance fakeDaggers of Feature
	(properties
		sel_20 {fakeDaggers}
		sel_1 270
		sel_0 114
		sel_213 7
		sel_301 40
		sel_302 4096
		sel_303 254
		sel_304 141
	)
	
	(method (sel_300 param1)
		(if (== param1 8)
			(global2 sel_422: inPittsburgh 0 1)
		else
			(super sel_300: param1)
		)
	)
)

(instance realDagger of Feature
	(properties
		sel_20 {realDagger}
		sel_1 249
		sel_0 115
		sel_213 8
		sel_6 104
		sel_7 240
		sel_8 116
		sel_9 260
		sel_301 40
		sel_303 249
		sel_304 109
	)
	
	(method (sel_300 param1)
		(if
			(and
				(or (== param1 8) (== param1 1))
				(== global123 2)
				(not (& global124 $7204))
			)
			(global2 sel_422: inPittsburgh)
		else
			(super sel_300: param1)
		)
	)
)

(instance footedPot of Feature
	(properties
		sel_20 {footedPot}
		sel_1 231
		sel_0 153
		sel_213 14
		sel_6 151
		sel_7 224
		sel_8 156
		sel_9 239
		sel_301 40
		sel_303 235
		sel_304 166
	)
)

(instance largePicture of Feature
	(properties
		sel_20 {largePicture}
		sel_1 285
		sel_0 74
		sel_213 5
		sel_301 40
		sel_302 2048
		sel_303 261
		sel_304 149
	)
)

(instance littleThings of Feature
	(properties
		sel_20 {littleThings}
		sel_1 225
		sel_0 133
		sel_213 15
		sel_301 40
		sel_302 1024
		sel_303 235
		sel_304 166
	)
)

(instance leftShelves of Feature
	(properties
		sel_20 {leftShelves}
		sel_1 43
		sel_0 70
		sel_213 1
		sel_301 40
		sel_302 512
		sel_303 69
		sel_304 130
	)
)

(instance nefertiti of Feature
	(properties
		sel_20 {nefertiti}
		sel_1 10
		sel_0 107
		sel_213 12
		sel_6 97
		sel_7 2
		sel_8 117
		sel_9 19
		sel_301 40
		sel_303 40
		sel_304 153
	)
)

(instance fakeNefertiti of Feature
	(properties
		sel_20 {fakeNefertiti}
		sel_1 48
		sel_0 75
		sel_213 13
		sel_6 69
		sel_7 43
		sel_8 81
		sel_9 53
		sel_301 40
		sel_303 73
		sel_304 127
	)
)

(instance purplePots of Feature
	(properties
		sel_20 {purplePots}
		sel_1 253
		sel_0 124
		sel_213 10
		sel_301 40
		sel_302 256
		sel_303 247
		sel_304 135
	)
)

(instance rug of Feature
	(properties
		sel_20 {rug}
		sel_1 132
		sel_0 141
		sel_213 11
		sel_301 40
		sel_302 128
		sel_303 132
		sel_304 141
	)
)

(instance rightShelves of Feature
	(properties
		sel_20 {rightShelves}
		sel_1 270
		sel_0 113
		sel_213 3
		sel_301 40
		sel_302 64
		sel_303 254
		sel_304 141
	)
)

(instance smallPicture of Feature
	(properties
		sel_20 {smallPicture}
		sel_1 248
		sel_0 64
		sel_213 4
		sel_301 40
		sel_302 32
		sel_303 234
		sel_304 117
	)
)
