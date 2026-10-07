;;; Sierra Script 1.0 - (do not remove this comment)
(script# 335)
(include sci.sh)
(use Main)
(use Door)
(use LBRoom)
(use ExitFeature)
(use Scaler)
(use PolyPath)
(use CueObj)
(use StopWalk)
(use Cycle)
(use Obj)

(public
	rm335 0
)

(instance rm335 of LBRoom
	(properties
		sel_20 {rm335}
		sel_213 5
		sel_408 335
		sel_409 350
		sel_411 330
	)
	
	(method (sel_110)
		(gEgo
			sel_110:
			sel_585: (if (gEgo sel_584?) 831 else 830)
			sel_320: Scaler 100 75 190 160
		)
		(self sel_414: 90 93)
		(switch gGSel_40
			(sel_409
				(Palette palSET_INTENSITY 0 255 60)
				(if (and (proc0_10 8) (not (proc0_2 133)))
					(frontDoor sel_4: 255 sel_29: 2 sel_599: 2 sel_596: 0)
					(self sel_146: sOffToSmooch)
				else
					(frontDoor sel_595: 1)
					(gEgo
						sel_153: (frontDoor sel_597?) (frontDoor sel_598?)
						sel_349: 0
					)
				)
			)
			(sel_411
				(self sel_146: sEnterSouth)
				(cond 
					((!= global123 2))
					((proc0_2 25) (gSel_608 sel_40: 335 sel_99: 1 sel_155: -1 sel_39: 50))
					(else (gSel_608 sel_40: 19 sel_99: 1 sel_155: -1 sel_39:))
				)
			)
			(else 
				(gEgo sel_153: 150 180)
				(gGame sel_588:)
			)
		)
		(super sel_110:)
		(southExitFeature sel_110:)
		(frontDoor sel_110: sel_63: 12)
		(otherDoor sel_110:)
		(banner sel_110: sel_311: 4 8)
		(glass sel_110:)
		(column sel_110:)
		(if (and (== global123 2) (not (proc0_2 25)))
			((ScriptID 32 0)
				sel_110:
				sel_2: 341
				sel_620: gSel_40
				sel_153: 131 173 0
				sel_155: 0
				sel_299: doorActions
				sel_303: 137
				sel_304: 180
				sel_311: 4 11 2 6
			)
		else
			(frontDoor sel_590: (!= global123 2))
		)
	)
	
	(method (sel_399)
		(gSel_608 sel_170:)
		(super sel_399: &rest)
	)
)

(instance sEnterSouth of Script
	(properties
		sel_20 {sEnterSouth}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gEgo sel_153: 165 240 sel_312: PolyPath 165 185 self)
			)
			(1
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sExitNorth of Script
	(properties
		sel_20 {sExitNorth}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(frontDoor sel_143: self sel_189:)
			)
			(1
				(gEgo
					sel_312: PolyPath (frontDoor sel_597?) (frontDoor sel_598?) self
				)
			)
			(2
				(DrawPic 780 dpOPEN_FADEPALETTE)
				(gSel_561 sel_119: 102)
				(= sel_136 2)
			)
			(3
				(Palette palSET_INTENSITY 0 255 100)
				((ScriptID 21 0) sel_57: 265)
				(global2 sel_399: (global2 sel_409?))
			)
		)
	)
)

(instance sGiveInvite of Script
	(properties
		sel_20 {sGiveInvite}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				((ScriptID 32 0)
					sel_155: 0
					sel_244: 6
					sel_161: CT 8 1 self
				)
			)
			(1 (= sel_139 15))
			(2
				((ScriptID 32 0) sel_161: End self)
			)
			(3
				((ScriptID 32 0) sel_156: 0)
				(= sel_136 2)
			)
			(4
				(gLb2Messager sel_295: 6 11 0 0 self)
			)
			(5
				(proc0_3 23)
				(gEgo sel_351: 6)
				((ScriptID 21 1) sel_57: 775)
				((ScriptID 22 0) sel_57: 28673)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sOffToSmooch of Script
	(properties
		sel_20 {sOffToSmooch}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gEgo sel_153: 153 160 sel_312: PolyPath 160 250 self)
				(= sel_136 1)
			)
			(1
				(DrawPic 335)
				(Palette palSET_INTENSITY 0 255 60)
				(= sel_139 15)
			)
			(2
				((ScriptID 93 8)
					sel_110:
					sel_161: StopWalk -1
					sel_153: 153 160
					sel_312: PolyPath 130 260
				)
			)
			(3 (global2 sel_399: 330))
		)
	)
)

(instance frontDoor of Door
	(properties
		sel_20 {frontDoor}
		sel_1 164
		sel_0 162
		sel_213 3
		sel_303 152
		sel_304 173
		sel_2 336
		sel_597 152
		sel_598 152
		sel_599 0
		sel_600 0
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(cond 
					((not (gEgo sel_584?)) (gLb2Messager sel_295: sel_213 4 6))
					((not (proc0_2 23)) (gLb2Messager sel_295: sel_213 4 7))
					(else (global2 sel_146: sExitNorth))
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance southExitFeature of ExitFeature
	(properties
		sel_20 {southExitFeature}
		sel_6 184
		sel_7 80
		sel_8 189
		sel_9 290
		sel_33 11
		sel_583 3
		sel_213 4
	)
)

(instance banner of Feature
	(properties
		sel_20 {banner}
		sel_1 215
		sel_0 123
		sel_213 1
		sel_6 80
		sel_7 203
		sel_8 137
		sel_9 258
		sel_301 40
	)
)

(instance glass of Feature
	(properties
		sel_20 {glass}
		sel_1 140
		sel_0 70
		sel_213 2
		sel_301 40
		sel_302 8192
	)
)

(instance otherDoor of Feature
	(properties
		sel_20 {otherDoor}
		sel_1 131
		sel_0 141
		sel_213 16
		sel_6 115
		sel_7 121
		sel_8 167
		sel_9 142
		sel_301 40
	)
	
	(method (sel_300 param1)
		(if (== param1 4)
			(frontDoor sel_300: param1)
		else
			(super sel_300: param1)
		)
	)
)

(instance column of Feature
	(properties
		sel_20 {column}
		sel_1 30
		sel_0 170
		sel_213 8
		sel_301 40
		sel_302 16384
	)
)

(instance doorActions of Actions
	(properties
		sel_20 {doorActions}
	)
	
	(method (sel_300 param1)
		(return
			(switch param1
				(1 (gLb2Messager sel_295: 6 1))
				(4 (gLb2Messager sel_295: 6 4))
				(11
					(global2 sel_146: sGiveInvite)
				)
				(2
					(if (gEgo sel_238: 6)
						(gLb2Messager sel_295: 6 2 7)
					else
						(gLb2Messager sel_295: 6 2)
					)
				)
				(6 (gLb2Messager sel_295: 6 2))
				(else  (return 0))
			)
		)
	)
)
