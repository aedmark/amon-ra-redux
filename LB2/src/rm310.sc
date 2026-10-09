;;; Sierra Script 1.0 - (do not remove this comment)
(script# 310)
(include sci.sh)
(use Main)
(use Door)
(use LBRoom)
(use ExitFeature)
(use RTRandCycle)
(use Scaler)
(use PolyPath)
(use Polygon)
(use CueObj)
(use n958)
(use Cycle)
(use View)
(use Obj)

(public
	rm310 0
	Bartender 22
	PianoPlayer 30
	Singer 31
)

(local
	local0 =  1
	local1 =  1
	local2 =  1
	local3 =  1
)
(procedure (localproc_03c5 &tmp temp0)
	(switch (= temp0 (global2 sel_422: (ScriptID 20 0)))
		(1026
			(gLb2Messager sel_295: 1 6 28)
		)
		(1027
			(gLb2Messager sel_295: 1 6 30)
		)
		(259
			(gLb2Messager sel_295: 1 6 17)
		)
		(1029
			(gLb2Messager sel_295: 1 6 12)
		)
		(261
			(gLb2Messager sel_295: 1 6 9)
		)
		(780
			(gLb2Messager sel_295: 1 6 20)
		)
		(516
			(gLb2Messager sel_295: 1 6 24)
		)
		(1028
			((ScriptID 21 0) sel_57: 268)
			(gLb2Messager sel_295: 1 6 31)
		)
		(262
			(gLb2Messager sel_295: 1 6 15)
		)
		(518
			(gLb2Messager sel_295: 1 6 35)
		)
		(517
			(gLb2Messager sel_295: 1 6 19)
		)
		(519
			(gLb2Messager sel_295: 1 6 29)
		)
		(513
			(gLb2Messager sel_295: 1 6 23)
		)
		(260
			(gLb2Messager sel_295: 1 6 13)
		)
		(258
			(gLb2Messager sel_295: 1 6 16)
		)
		(514
			(gLb2Messager sel_295: 1 6 22)
		)
		(268
			(gLb2Messager sel_295: 1 6 27)
		)
		(520
			(gLb2Messager sel_295: 1 6 35)
		)
		(263
			(gLb2Messager sel_295: 1 6 14)
		)
		(264
			(gLb2Messager sel_295: 1 6 3)
		)
		(-1 0)
		(else 
			(cond 
				((and (<= 256 temp0) (<= temp0 409)) (gLb2Messager sel_295: 1 6 18))
				((and (<= 768 temp0) (<= temp0 921)) (gLb2Messager sel_295: 1 6 26))
				(else (gLb2Messager sel_295: 1 6 21))
			)
		)
	)
)

(instance rm310 of LBRoom
	(properties
		sel_20 {rm310}
		sel_213 13
		sel_408 310
		sel_409 320
		sel_411 300
		sel_107 167
		sel_108 -20
	)
	
	(method (sel_110 &tmp [temp0 3] temp3 [temp4 30])
		(proc958_0 128 311 317 312 313 314 315 318 831 830)
		(proc958_0 132 310 311 312 314)
		(gEgo
			sel_320: Scaler 137 0 190 -20
			sel_110:
			sel_585: (if (gEgo sel_584?) 831 else 830)
		)
		(switch gGSel_40
			(sel_409
				(gEgo sel_1: 236 sel_0: 107 sel_349: 0 sel_253: 180)
				(gSel_608 sel_172: 127)
				(gGameMusic2 sel_167:)
			)
			(sel_411
				(gEgo sel_1: 195)
				(= temp3
					(if (== (DoSound sndGET_POLYPHONY) 32) 310 else 314)
				)
			)
			(else 
				(gEgo sel_153: 160 160)
				(gGame sel_588:)
			)
		)
		(super sel_110:)
		(proc958_0 128 311 317 312 313 314 315 318 831 830)
		(proc958_0 132 310 311 312 314)
		(if (== gGSel_40 sel_411)
			(switch (Random 0 2)
				(0
					(WrapMusic sel_110: 1 temp3 311 1312)
				)
				(1
					(WrapMusic sel_110: 1 311 temp3 1312)
				)
				(2
					(WrapMusic sel_110: 1 1312 temp3 311)
				)
			)
		)
		(self
			sel_395:
				((Polygon sel_109:)
					sel_31: 2
					sel_110:
						26
						189
						0
						189
						0
						0
						319
						0
						319
						189
						287
						189
						238
						172
						201
						118
						245
						111
						245
						97
						274
						92
						258
						69
						219
						108
						193
						112
						174
						115
						168
						127
						119
						122
						85
						152
					sel_117:
				)
		)
		(bartender sel_311: 1 2 6 sel_317:)
		(barfly1 sel_317:)
		(barfly2 sel_317:)
		(ziggy sel_311: 1 2 6 sel_110: sel_146: sZiggySmokes)
		(woman2 sel_317:)
		(dancersA sel_110: sel_146: sRDancers)
		(dancersB sel_110: sel_146: sMDancers)
		(dancersC sel_161: Fwd sel_110:)
		(flapper sel_161: Fwd sel_110:)
		(pianoplayer sel_110: sel_161: Fwd)
		(sleeper sel_317:)
		(woman1 sel_317:)
		(bathroomDoor sel_110:)
		(endOfBar sel_110:)
		(southExitFeature sel_110:)
		((ScriptID 1881 2)
			sel_1: 5
			sel_0: 95
			sel_549: 120
			sel_550: 20
			sel_537: 120
		)
	)
	
	(method (sel_399 param1)
		(if (== param1 320)
			(gSel_608 sel_170: 80 10 12 0)
		else
			(WrapMusic sel_111:)
		)
		(super sel_399: param1)
	)
)

(instance sRDancers of Script
	(properties
		sel_20 {sRDancers}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(dancersA sel_2: 313 sel_3: 0 sel_161: Fwd)
				(= sel_137 (Random 5 10))
			)
			(1
				(dancersA sel_2: 313 sel_3: 1 sel_161: Fwd)
				(= sel_137 (Random 4 6))
			)
			(2 (= sel_29 -1) (= sel_136 1))
		)
	)
)

(instance sMDancers of Script
	(properties
		sel_20 {sMDancers}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(dancersB sel_2: 313 sel_3: 2 sel_161: Fwd)
				(= sel_137 (Random 4 7))
			)
			(1
				(dancersB sel_2: 314 sel_3: 2 sel_161: End self)
			)
			(2
				(dancersB sel_2: 313 sel_3: 3 sel_161: Fwd)
				(= sel_137 (Random 4 8))
			)
			(3
				(dancersB sel_2: 314 sel_3: 2 sel_4: 11 sel_161: Beg self)
			)
			(4 (= sel_29 -1) (= sel_136 1))
		)
	)
)

(instance sBartender of Script
	(properties
		sel_20 {sBartender}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(bartender sel_155: 2)
				(= sel_137 (Random 9 19))
			)
			(1
				(switch (Random 0 1)
					(0
						(bartender sel_155: 1 sel_312: MoveTo 55 113 self)
					)
					(1
						(bartender sel_155: 0 sel_312: MoveTo 7 123 self)
					)
				)
			)
			(2
				(if (> (bartender sel_1?) 10)
					(bartender sel_155: 0)
				else
					(bartender sel_155: 1)
				)
				(bartender sel_312: MoveTo 47 115 self)
			)
			(3 (= sel_29 -1) (= sel_136 1))
		)
	)
)

(instance sZiggySmokes of Script
	(properties
		sel_20 {sZiggySmokes}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (ziggy sel_161: End self))
			(1 (= sel_137 (Random 1 6)))
			(2
				(switch (Random 0 2)
					(0 (= sel_136 1))
					(else 
						(ziggy sel_4: 3 sel_161: End self)
					)
				)
			)
			(3
				(ziggy sel_4: 3 sel_161: CT 0 -1 self)
			)
			(4 (= sel_137 (Random 2 4)))
			(5 (= sel_29 -1) (= sel_136 1))
		)
	)
)

(instance sNodder of Script
	(properties
		sel_20 {sNodder}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (woman2 sel_161: End self))
			(1 (= sel_136 (Random 1 10)))
			(2 (woman2 sel_161: Beg self))
			(3 (= sel_136 (Random 10 20)))
			(4 (= sel_29 -1) (= sel_136 1))
		)
	)
)

(instance sWhoSentYa of Script
	(properties
		sel_20 {sWhoSentYa}
	)
	
	(method (sel_144 theSel_29 &tmp temp0)
		(switch (= sel_29 theSel_29)
			(0
				(gLb2Messager sel_295: 1 2 6 0 self)
				(= local1 0)
				((ScriptID 22 0) sel_57: 8)
				(gGame sel_87: 1 131)
			)
			(1
				(switch (= temp0 (global2 sel_422: (ScriptID 20 0)))
					(261
						(gLb2Messager sel_295: 1 2 8 0 self)
						(proc0_3 118)
					)
					(else 
						(if (and (<= 256 temp0) (<= temp0 409))
							(gLb2Messager sel_295: 1 2 7 0 self)
						else
							(gLb2Messager sel_295: 1 6 21 0 self)
						)
						(proc0_4 118)
					)
				)
			)
			(2 (self sel_111:))
		)
	)
)

(instance sLeaveSouth of Script
	(properties
		sel_20 {sLeaveSouth}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo sel_312: PolyPath gSel_1 190 self)
			)
			(2
				(gEgo sel_312: MoveTo (gEgo sel_1?) 270 self)
			)
			(3 (global2 sel_399: 300))
		)
	)
)

(instance bartender of View
	(properties
		sel_20 {bartender}
		sel_1 47
		sel_0 115
		sel_213 2
		sel_303 113
		sel_304 129
		sel_2 312
		sel_3 2
	)
	
	(method (sel_300 param1)
		(switch param1
			(6
				(switch (global2 sel_422: (ScriptID 20 0))
					(264
						(gLb2Messager sel_295: 2 6 3 0)
					)
					(-1 0)
					(else 
						(gLb2Messager sel_295: 2 6 4 0)
					)
				)
			)
			(2
				(gLb2Messager sel_295: 2 2 0 0)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance barfly1 of View
	(properties
		sel_20 {barfly1}
		sel_1 59
		sel_0 148
		sel_213 3
		sel_2 312
		sel_3 3
		sel_60 10
		sel_14 16
	)
)

(instance barfly2 of View
	(properties
		sel_20 {barfly2}
		sel_1 81
		sel_0 140
		sel_213 10
		sel_2 312
		sel_3 4
		sel_60 10
		sel_14 16
	)
)

(instance ziggy of Prop
	(properties
		sel_20 {ziggy}
		sel_1 292
		sel_0 124
		sel_213 1
		sel_303 232
		sel_304 157
		sel_2 318
		sel_4 5
		sel_60 12
		sel_14 4112
	)
	
	(method (sel_300 param1 &tmp temp0)
		(switch param1
			(6
				(cond 
					((and (proc0_10 8 0) (proc0_2 118)) (localproc_03c5))
					(local1 (gLb2Messager sel_295: 1 2 33 2))
					((proc0_2 118) (localproc_03c5))
					(else
						(switch (global2 sel_422: (ScriptID 20 0))
							(261
								(gLb2Messager sel_295: 1 6 9 0)
								(proc0_3 118)
							)
							(else 
								(gLb2Messager sel_295: 1 6 21 0)
							)
						)
					)
				)
			)
			(2
				(cond 
					((proc0_10 8 0) (gLb2Messager sel_295: 1 2 32))
					(local1 (global2 sel_146: sWhoSentYa))
					(local2
						(if (proc0_2 118)
							(gLb2Messager sel_295: 1 2 32)
						else
							(gLb2Messager sel_295: 1 2 33)
						)
						(= local2 0)
					)
					(local3
						(if (proc0_2 118)
							(gLb2Messager sel_295: 1 2 34)
						else
							(gLb2Messager sel_295: 1 2 33)
						)
					)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance flapper of Prop
	(properties
		sel_20 {flapper}
		sel_1 141
		sel_0 87
		sel_213 4
		sel_2 315
		sel_4 1
	)
	
	(method (sel_300 param1)
		(switch param1
			(6
				(switch (global2 sel_422: (ScriptID 20 0))
					(-1 0)
					(else 
						(gLb2Messager sel_295: 4 6 5)
					)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance pianoplayer of Prop
	(properties
		sel_20 {pianoplayer}
		sel_1 116
		sel_0 83
		sel_213 5
		sel_2 315
		sel_3 1
		sel_4 13
	)
	
	(method (sel_300 param1)
		(switch param1
			(6
				(switch (global2 sel_422: (ScriptID 20 0))
					(-1 0)
					(else 
						(gLb2Messager sel_295: 5 6 5)
					)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance sleeper of View
	(properties
		sel_20 {sleeper}
		sel_1 287
		sel_0 117
		sel_213 6
		sel_2 317
		sel_3 1
		sel_4 3
	)
)

(instance woman1 of View
	(properties
		sel_20 {woman1}
		sel_1 261
		sel_0 100
		sel_213 11
		sel_2 317
		sel_4 3
		sel_60 8
		sel_14 16
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if local0
					(gLb2Messager sel_295: 11 1 1)
					(= local0 0)
				else
					(gLb2Messager sel_295: 11 1 2)
				)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance woman2 of View
	(properties
		sel_20 {woman2}
		sel_1 236
		sel_0 101
		sel_213 11
		sel_2 317
		sel_3 2
		sel_60 8
		sel_14 16400
	)
	
	(method (sel_300 param1)
		(woman1 sel_300: param1)
	)
)

(instance dancersA of Prop
	(properties
		sel_20 {dancersA}
		sel_1 183
		sel_0 111
		sel_213 8
		sel_2 313
		sel_4 1
		sel_14 4096
	)
)

(instance dancersB of Prop
	(properties
		sel_20 {dancersB}
		sel_1 151
		sel_0 121
		sel_213 8
		sel_2 313
		sel_3 3
		sel_4 5
		sel_14 4096
	)
)

(instance dancersC of Prop
	(properties
		sel_20 {dancersC}
		sel_1 106
		sel_0 114
		sel_213 8
		sel_2 313
		sel_3 4
		sel_4 2
	)
)

(instance bathroomDoor of Door
	(properties
		sel_20 {bathroomDoor}
		sel_1 215
		sel_0 51
		sel_213 9
		sel_303 228
		sel_304 109
		sel_2 311
		sel_589 320
		sel_597 255
		sel_598 95
		sel_599 0
		sel_600 0
	)
	
	(method (sel_606)
		(super sel_606: 211 100 253 100 253 109 211 109)
	)
)

(instance endOfBar of Feature
	(properties
		sel_20 {endOfBar}
		sel_0 136
		sel_6 99
		sel_7 90
		sel_8 131
		sel_9 110
	)
)

(instance southExitFeature of ExitFeature
	(properties
		sel_20 {southExitFeature}
		sel_6 184
		sel_8 189
		sel_9 319
		sel_33 11
		sel_583 3
		sel_213 12
	)
	
	(method (sel_133 param1)
		(cond 
			((not (gUser sel_342?)))
			((not (self sel_218: gSel_1 (- gSel_0 10))))
			(
				(or
					(and (== (param1 sel_31?) 4) (!= (param1 sel_37?) 13))
					(and (== (param1 sel_31?) 1) (param1 sel_61?))
					(not (proc999_5 (param1 sel_31?) 1 4))
				)
				(= sel_582 -1)
			)
			((== gSel_582 ((gIconBar sel_64: 1) sel_33?)) (param1 sel_73: 1) (gLb2Messager sel_295: sel_213 1))
			((!= gSel_582 sel_33))
			(else (param1 sel_73: 1) (global2 sel_146: sLeaveSouth))
		)
	)
)

(instance Bartender of Narrator
	(properties
		sel_20 {Bartender}
		sel_1 100
		sel_0 100
		sel_537 150
		sel_26 15
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: &rest)
	)
)

(instance Singer of Narrator
	(properties
		sel_20 {Singer}
		sel_1 100
		sel_0 100
		sel_537 150
		sel_26 15
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: &rest)
	)
)

(instance PianoPlayer of Narrator
	(properties
		sel_20 {PianoPlayer}
		sel_1 100
		sel_0 100
		sel_537 150
		sel_26 15
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: &rest)
	)
)
