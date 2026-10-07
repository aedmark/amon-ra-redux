;;; Sierra Script 1.0 - (do not remove this comment)
(script# 355)
(include sci.sh)
(use Main)
(use LBRoom)
(use Inset)
(use RTRandCycle)
(use Scaler)
(use Osc)
(use PolyPath)
(use StopWalk)
(use View)
(use Obj)

(public
	rm355 0
	tkrLaura 2
	tkrErnie 23
)

(local
	local0
)
(instance rm355 of LBRoom
	(properties
		sel_20 {rm355}
		sel_213 5
		sel_408 350
	)
	
	(method (sel_110)
		(gEgo sel_110: sel_585: 831 sel_320: Scaler 95 75 190 120)
		(self sel_414: 90)
		(Palette palSET_INTENSITY 0 255 0)
		(self
			sel_146: (if (proc0_2 34) sPartysOver else sIllegal)
		)
		(super sel_110:)
	)
)

(instance sPartysOver of Script
	(properties
		sel_20 {sPartysOver}
	)
	
	(method (sel_57)
		(if (< local0 100)
			(Palette palSET_INTENSITY 0 255 (= local0 (+ local0 2)))
			(if (== local0 100) (self sel_145:))
		)
		(super sel_57:)
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_153: 245 165 sel_3: 8 sel_156: 5)
				((ScriptID 32 0)
					sel_182: 355
					sel_648: 814
					sel_110:
					sel_155: 8
					sel_156: 2
					sel_153: 190 175
					sel_316: 1
				)
				((ScriptID 90 3)
					sel_182: 355
					sel_2: 353
					sel_155: 1
					sel_153: 204 185
					sel_316: 1
				)
				((ScriptID 90 5)
					sel_182: 355
					sel_2: 815
					sel_153: 147 184
					sel_316: 1
					sel_161: StopWalk -1
					sel_312: PolyPath 184 184 self
				)
				((ScriptID 90 1)
					sel_182: 355
					sel_2: 813
					sel_153: 119 184
					sel_316: 1
					sel_161: StopWalk -1
					sel_312: PolyPath 161 184
				)
				((ScriptID 90 6)
					sel_182: 355
					sel_2: 817
					sel_153: 85 184
					sel_316: 1
					sel_161: StopWalk -1
					sel_312: PolyPath 132 184
				)
				(= sel_136 1)
			)
			(1
				((ScriptID 32 0) sel_317:)
				(gSel_608 sel_40: 350 sel_155: -1 sel_99: 1 sel_39:)
			)
			(2 0)
			(3
				(gLb2Messager sel_295: 2)
				((ScriptID 90 3) sel_161: Osc 2 self)
			)
			(4
				((ScriptID 22 0) sel_57: -24576 self)
			)
			(5
				((ScriptID 90 5) sel_312: PolyPath 330 182)
				((ScriptID 90 1) sel_312: PolyPath 184 184 self)
				((ScriptID 90 6) sel_312: PolyPath 146 184)
			)
			(6
				((ScriptID 90 3) sel_161: Osc 3 self)
			)
			(7
				((ScriptID 90 1) sel_312: PolyPath 330 182)
				((ScriptID 90 6) sel_312: PolyPath 184 184 self)
			)
			(8
				((ScriptID 90 3) sel_161: Osc 2 self)
			)
			(9
				((ScriptID 90 6) sel_312: PolyPath 330 182 self)
			)
			(10
				((ScriptID 90 6) sel_111:)
				((ScriptID 90 5) sel_111:)
				((ScriptID 90 1) sel_111:)
				(proc0_3 42)
				(gSel_608 sel_170:)
				(= sel_139 60)
			)
			(11
				(gSel_608 sel_40: 642 sel_3: -1 sel_99: 1 sel_39:)
				((ScriptID 31 0)
					sel_620: gSel_40
					sel_110:
					sel_153: 350 182
					sel_161: StopWalk -1
					sel_312: PolyPath (+ (gEgo sel_1?) 10) (+ (gEgo sel_0?) 10) self
				)
			)
			(12 (= sel_136 2))
			(13
				(global2 sel_422: inErnie_Laura)
				(= sel_136 2)
			)
			(14
				(gLb2Messager sel_295: 4 0 1 0 self)
			)
			(15
				(proc0_3 91)
				(global2 sel_422: 0)
				((ScriptID 32 0)
					sel_153:
						(- ((ScriptID 90 3) sel_1?) 25)
						(- ((ScriptID 90 3) sel_0?) 10)
					sel_155: 8
					sel_156: 4
				)
				((ScriptID 21 0) sel_57: 267)
				((ScriptID 31 0) sel_312: PolyPath 350 185 self)
				(gSel_608 sel_170:)
			)
			(16
				(gLb2Messager sel_295: 1 0 0 0 self)
			)
			(17
				(WrapMusic sel_110: 1 90 91 92 93)
				(gEgo sel_312: PolyPath 340 185 self)
			)
			(18 (global2 sel_399: 370))
		)
	)
)

(instance sIllegal of Script
	(properties
		sel_20 {sIllegal}
	)
	
	(method (sel_57)
		(if (< local0 100)
			(Palette palSET_INTENSITY 0 255 (= local0 (+ local0 2)))
			(if (== local0 100) (self sel_145:))
		)
		(super sel_57:)
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_588:)
				(proc0_3 91)
				(= global123 0)
				(gUser sel_347: 0 sel_237: 0)
				((ScriptID 32 0)
					sel_620: gSel_40
					sel_648: 814
					sel_110:
					sel_155: 8
					sel_156: 2
					sel_153: 190 175
				)
				((ScriptID 90 3)
					sel_620: gSel_40
					sel_2: 819
					sel_155: 8
					sel_156: 2
					sel_153: 210 180
				)
				(gEgo sel_153: 230 182 sel_155: 8 sel_156: 2)
			)
			(1
				(gLb2Messager sel_295: 3 0 0 0 self)
			)
			(2 (= sel_137 5))
			(3
				(= global145 3)
				(global2 sel_399: 99)
			)
		)
	)
)

(instance inErnie_Laura of Inset
	(properties
		sel_20 {inErnie&Laura}
		sel_408 475
		sel_560 1
	)
)

(instance tkrErnie of Talker
	(properties
		sel_20 {tkrErnie}
		sel_2 1475
		sel_3 1
		sel_537 250
		sel_26 15
		sel_549 20
		sel_550 120
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: 0 ernieEyes ernieMouth &rest)
	)
)

(instance ernieMouth of Prop
	(properties
		sel_20 {ernieMouth}
		sel_6 82
		sel_7 119
		sel_2 1475
	)
)

(instance ernieEyes of Prop
	(properties
		sel_20 {ernieEyes}
		sel_6 67
		sel_7 122
		sel_2 1475
		sel_3 2
	)
)

(instance tkrLaura of Narrator
	(properties
		sel_20 {tkrLaura}
		sel_1 150
		sel_0 130
		sel_26 15
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: &rest)
	)
)
