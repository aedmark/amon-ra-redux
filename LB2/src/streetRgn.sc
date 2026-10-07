;;; Sierra Script 1.0 - (do not remove this comment)
(script# 91)
(include sci.sh)
(use Main)
(use CueObj)
(use MoveFwd)
(use n958)
(use Sound)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	streetRgn 0
	streetSounds 1
)

(local
	local0
	local1
	local2
	local3
)
(instance streetRgn of Rgn
	(properties
		sel_20 {streetRgn}
	)
	
	(method (sel_110)
		(Load rsVIEW 853)
		(proc958_0 132 96 94 81)
		(leftFeature sel_110:)
		(rightFeature sel_110:)
		(car sel_155: 3 sel_156: 3 sel_51: 6 sel_53: 3 sel_102:)
		(if (not (streetSounds sel_90?))
			(streetSounds sel_39:)
		)
		(super sel_110:)
	)
	
	(method (sel_57)
		(cond 
			((global2 sel_142?))
			(
			(and (== local0 1) (== local1 1) (proc0_1 gEgo 4)) (global2 sel_146: sLeaveNow))
			(
				(and
					(not (if (== local0 1) (== local1 1)))
					(proc0_1 gEgo 4)
				)
				(global2 sel_146: sRunOver)
			)
			((proc0_1 gEgo 256) (global2 sel_146: sHitEdgeScreen))
		)
		(super sel_57:)
	)
	
	(method (sel_399 param1)
		(= sel_406 (proc999_5 param1 280 210 260 300))
		(= sel_407 0)
	)
)

(instance sLeaveNow of Script
	(properties
		sel_20 {sLeaveNow}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_55: 180)
				(= sel_136 2)
			)
			(1
				(gEgo sel_312: MoveFwd 65 self)
			)
			(2
				(global2 sel_399: (global2 sel_411?))
			)
		)
	)
)

(instance sRunOver of Script
	(properties
		sel_20 {sRunOver}
	)
	
	(method (sel_57)
		(cond 
			(
			(and (< (car sel_255: gEgo) 160) (not local2)) (mRunOver sel_40: 96 sel_3: -1 sel_39:) (= local2 1))
			(
			(and (< (car sel_255: gEgo) 100) (not local3)) (mRunOver sel_40: 81 sel_3: 1 sel_39:) (= local3 1))
		)
		(super sel_57:)
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(streetSounds sel_167:)
				(if (== gSel_40 280)
					((ScriptID 280 1) sel_111:)
					((ScriptID 280 2) sel_146: 0)
				)
				(gEgo sel_63: 13)
				(car sel_110:)
				(= sel_136 1)
			)
			(1
				(car
					sel_312: MoveTo (+ (gEgo sel_1?) 55) (- (gEgo sel_0?) 1) self
				)
			)
			(2
				(switch gSel_40
					(210
						(car sel_312: MoveTo 160 225)
					)
					(260
						(car sel_312: MoveTo -30 251)
					)
					(280
						(car sel_312: MoveTo 112 221)
					)
					(300
						(car sel_312: MoveTo 220 215)
					)
				)
				(= sel_136 1)
			)
			(3
				(gEgo
					sel_2: 853
					sel_3: (if (== (gEgo sel_2?) 803) 1 else 0)
					sel_4: 0
					sel_153: (- (gEgo sel_1?) 19) (- (gEgo sel_0?) 1)
					sel_244: 8
					sel_161: End self
				)
			)
			(4
				(= sel_137 7)
				(if (gEgo sel_59?) (gEgo sel_155: 0))
			)
			(5
				(= global145 9)
				(global2 sel_399: 99)
			)
		)
	)
)

(instance sHitEdgeScreen of Script
	(properties
		sel_20 {sHitEdgeScreen}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gLb2Messager sel_295: 4 3 0 0 self 91)
			)
			(1
				(if (> (gEgo sel_55?) 180)
					(gEgo sel_253: 90)
				else
					(gEgo sel_253: 270)
				)
				(gEgo sel_312: MoveFwd 10 self)
			)
			(2
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance leftFeature of Feature
	(properties
		sel_20 {leftFeature}
		sel_1 28
		sel_0 100
		sel_6 88
		sel_8 189
		sel_9 20
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(= local0 1)
				(gLb2Messager sel_295: 1 1 0 0 0 91)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance rightFeature of Feature
	(properties
		sel_20 {rightFeature}
		sel_1 287
		sel_0 100
		sel_6 88
		sel_7 300
		sel_8 189
		sel_9 320
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(= local1 1)
				(gLb2Messager sel_295: 2 1 0 0 0 91)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance car of Actor
	(properties
		sel_20 {car}
		sel_1 362
		sel_0 181
		sel_2 213
		sel_3 3
		sel_4 3
		sel_14 16384
		sel_53 3
	)
)

(instance mRunOver of Sound
	(properties
		sel_20 {mRunOver}
		sel_99 5
	)
)

(instance streetSounds of Sound
	(properties
		sel_20 {streetSounds}
		sel_99 1
		sel_40 94
		sel_3 -1
	)
)
