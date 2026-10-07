;;; Sierra Script 1.0 - (do not remove this comment)
(script# 320)
(include sci.sh)
(use Main)
(use LBRoom)
(use ExitFeature)
(use Print)
(use Scaler)
(use PolyPath)
(use Polygon)
(use CueObj)
(use MoveFwd)
(use n958)
(use Cycle)
(use View)
(use Obj)

(public
	rm320 0
)

(local
	local0
)
(instance rm320 of LBRoom
	(properties
		sel_20 {rm320}
		sel_213 7
		sel_408 320
		sel_411 310
		sel_108 -60
	)
	
	(method (sel_110)
		(proc958_0 128 321 322 318 831 830)
		(Load rsSOUND 321)
		(gEgo
			sel_110:
			sel_1: 133
			sel_0: 182
			sel_299: aPutOnDress
			sel_585: (if (gEgo sel_584?) 831 else 830)
			sel_320: Scaler 145 0 190 0
		)
		(switch gGSel_40
			(sel_411
				(if (not (proc0_2 24))
					(global2 sel_146: sEnterRm1stTime)
				else
					(global2 sel_146: sEnterRmNthTime)
				)
			)
			(else 
				(gEgo sel_153: 160 130)
				(gGame sel_588:)
			)
		)
		(super sel_110:)
		(self
			sel_395:
				((Polygon sel_109:)
					sel_31: 3
					sel_110:
						236
						150
						199
						102
						146
						102
						120
						102
						107
						109
						144
						109
						128
						134
						110
						146
						77
						146
						78
						189
						182
						189
						181
						150
					sel_117:
				)
		)
		(gGameMusic2 sel_40: 321 sel_3: -1 sel_99: 1 sel_39:)
		(sleazy sel_311: 4 2 6 sel_110: sel_146: sSheAnimates)
		(smoke sel_110: sel_146: sDoSomethingLaura)
		(partition sel_110:)
		(stalls sel_110:)
		(sink sel_110:)
		(rm320Window sel_110:)
		(couch sel_110:)
		(southExitFeature sel_110:)
	)
	
	(method (sel_57)
		(cond 
			(sel_142)
			((proc0_1 gEgo 2) (global2 sel_146: sExitSouth))
		)
		(super sel_57:)
	)
)

(instance sExitSouth of Script
	(properties
		sel_20 {sExitSouth}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo
					sel_253: 180
					sel_312: MoveTo (gEgo sel_1?) 250 self
				)
			)
			(2
				(gSel_608 sel_170: 127 30 12 0)
				(global2 sel_399: 310)
				(self sel_111:)
			)
		)
	)
)

(instance sEnterRm1stTime of Script
	(properties
		sel_20 {sEnterRm1stTime}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo
					sel_153: 137 151
					sel_253: 1
					sel_312: MoveFwd 10 self
				)
			)
			(2
				(gLb2Messager sel_295: 1 0 1 1 self)
			)
			(3
				(Print
					sel_198: 12 0 0 0
					sel_205: 1 13 0 0 1 5 25
					sel_205: 1 13 0 0 2 5 50
					sel_110:
				)
				(gLb2Messager sel_295: 1 0 1 2 self)
			)
			(4
				(proc0_3 24)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sEnterRmNthTime of Script
	(properties
		sel_20 {sEnterRmNthTime}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo
					sel_153: 137 151
					sel_253: 1
					sel_312: MoveFwd 10 self
				)
			)
			(2
				(if (proc0_2 78)
					(gLb2Messager sel_295: 15 0 0 0 self)
					(proc0_4 78)
				else
					(gLb2Messager sel_295: 1 0 3 0 self)
				)
			)
			(3
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sLauraChanges of Script
	(properties
		sel_20 {sLauraChanges}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 3)
			)
			(1
				(gEgo
					sel_351: 32
					sel_584: 1
					sel_312: PolyPath 208 150 self
				)
				((ScriptID 22 0) sel_57: 16)
				(gGame sel_87: 1 132)
			)
			(2
				(gEgo sel_312: MoveTo 210 160 self)
			)
			(3
				(gEgo
					sel_2: 321
					sel_3: 0
					sel_153: (- (gEgo sel_1?) 3) (- (gEgo sel_0?) 45)
					sel_244: 10
					sel_53: 10
					sel_161: End self
				)
				(clothes sel_110: sel_161: End)
			)
			(4
				(gLb2Messager sel_295: 2 0 0 0)
				(gEgo sel_2: 321 sel_3: 1 sel_161: End self)
			)
			(5
				(gEgo
					sel_2: 831
					sel_3: 2
					sel_153: (+ (gEgo sel_1?) 3) (+ (gEgo sel_0?) 45)
				)
				(= sel_136 1)
			)
			(6
				(gEgo sel_161: Walk sel_312: MoveTo 208 150 self)
			)
			(7
				(= local0 1)
				(clothes sel_317:)
				(gGame sel_588:)
				(proc0_3 78)
				((ScriptID 21 1) sel_57: 801)
				(gEgo sel_585: 831)
				(self sel_111:)
			)
		)
	)
)

(instance sSheAnimates of Script
	(properties
		sel_20 {sSheAnimates}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(switch (Random 0 2)
					(0
						(self sel_146: sSheMoves self)
					)
					(else 
						(self sel_146: sSheSmokes self)
					)
				)
			)
			(1 (= sel_136 70))
			(2 (= sel_29 -1) (= sel_136 1))
		)
	)
)

(instance sSheSmokes of Script
	(properties
		sel_20 {sSheSmokes}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(sleazy sel_155: 0 sel_161: CT 9 1 self)
			)
			(1 (smoke sel_161: End self))
			(2
				(sleazy sel_161: End self)
				(smoke sel_4: 0)
			)
			(3 (= sel_136 (Random 30 70)))
			(4 (self sel_111:))
		)
	)
)

(instance sSheMoves of Script
	(properties
		sel_20 {sSheMoves}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(sleazy sel_4: 0 sel_155: 2 sel_161: End self)
			)
			(1 (= sel_136 100))
			(2
				(switch (Random 0 2)
					(0
						(gLb2Messager sel_295: 10 0 0 1 self)
					)
					(1
						(gLb2Messager sel_295: 10 0 0 2 self)
					)
					(2
						(gLb2Messager sel_295: 10 0 0 3 self)
					)
				)
			)
			(3
				(sleazy sel_155: 3 sel_161: Fwd)
				(= sel_136 (Random 30 60))
			)
			(4 (sleazy sel_161: End self))
			(5
				(sleazy sel_155: 2)
				(= sel_136 1)
			)
			(6
				(sleazy sel_4: (sleazy sel_246:) sel_161: Beg self)
			)
			(7 (self sel_111:))
		)
	)
)

(instance sDoSomethingLaura of Script
	(properties
		sel_20 {sDoSomethingLaura}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_137 50))
			(1
				(if (gEgo sel_584?)
					(self sel_111:)
				else
					(gLb2Messager sel_295: 11 0 0 1 self)
				)
			)
			(2 (= sel_29 -1) (= sel_136 1))
		)
	)
)

(instance aPutOnDress of Actions
	(properties
		sel_20 {aPutOnDress}
	)
	
	(method (sel_300 param1 &tmp temp0)
		(switch param1
			(42
				(global2 sel_146: sLauraChanges)
			)
			(else  0)
		)
	)
)

(instance sleazy of Prop
	(properties
		sel_20 {sleazy}
		sel_1 109
		sel_0 113
		sel_213 3
		sel_303 145
		sel_304 124
		sel_2 322
		sel_60 10
		sel_14 16
		sel_244 10
	)
	
	(method (sel_300 param1 &tmp temp0)
		(switch param1
			(2
				((ScriptID 21 0) sel_57: 269)
				(gLb2Messager sel_295: 3 2)
			)
			(6
				(switch (global2 sel_422: (ScriptID 20 0))
					(269
						(gLb2Messager sel_295: 3 6 7)
					)
					(264
						(gLb2Messager sel_295: 3 6 4)
					)
					(520
						(gLb2Messager sel_295: 3 6 9)
					)
					(-1 0)
					(else 
						(gLb2Messager sel_295: 3 6 5)
					)
				)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance smoke of Prop
	(properties
		sel_20 {smoke}
		sel_1 113
		sel_0 96
		sel_2 318
		sel_3 6
	)
	
	(method (sel_110)
		(self
			sel_153: (+ (sleazy sel_1?) 4) (- (sleazy sel_0?) 17)
		)
		(super sel_110:)
	)
)

(instance clothes of Prop
	(properties
		sel_20 {clothes}
		sel_1 207
		sel_0 114
		sel_2 321
		sel_3 2
		sel_4 10
		sel_60 15
		sel_14 16400
	)
)

(instance partition of Feature
	(properties
		sel_20 {partition}
		sel_1 217
		sel_0 130
		sel_213 4
		sel_6 109
		sel_7 185
		sel_8 151
		sel_9 250
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if local0
					(gLb2Messager sel_295: 4 1 8)
				else
					(gLb2Messager sel_295: 4 1 6)
				)
			)
			(4
				(if local0
					(gLb2Messager sel_295: 4 4 8)
				else
					(gLb2Messager sel_295: 4 4 6)
				)
			)
			(42
				(global2 sel_146: sLauraChanges)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance stalls of Feature
	(properties
		sel_20 {stalls}
		sel_1 170
		sel_0 68
		sel_213 5
		sel_6 40
		sel_7 139
		sel_8 96
		sel_9 202
		sel_301 40
	)
)

(instance sink of Feature
	(properties
		sel_20 {sink}
		sel_1 221
		sel_0 91
		sel_213 6
		sel_6 78
		sel_7 203
		sel_8 104
		sel_9 239
		sel_301 40
	)
)

(instance rm320Window of Feature
	(properties
		sel_20 {rm320Window}
		sel_1 239
		sel_0 57
		sel_213 9
		sel_6 51
		sel_7 229
		sel_8 63
		sel_9 249
		sel_301 40
	)
)

(instance couch of Feature
	(properties
		sel_20 {couch}
		sel_0 101
		sel_213 8
		sel_302 16384
	)
)

(instance southExitFeature of ExitFeature
	(properties
		sel_20 {southExitFeature}
		sel_6 149
		sel_7 69
		sel_8 154
		sel_9 192
		sel_33 11
		sel_583 3
		sel_213 14
	)
)
