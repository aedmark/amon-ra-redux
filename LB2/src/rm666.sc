;;; Sierra Script 1.0 - (do not remove this comment)
(script# 666)
(include sci.sh)
(use Main)
(use LBRoom)
(use n958)
(use Sound)
(use Cycle)
(use InvI)
(use User)
(use Obj)

(public
	rm666 0
)

(local
	local0
	local1
	local2
	local3
)
(instance rm666 of LBRoom
	(properties
		sel_20 {rm666}
	)
	
	(method (sel_110)
		(self sel_414: 90)
		(if (== gGSel_40 520)
			(gEgo sel_110: sel_153: 277 55 sel_585: 732)
			(proc0_3 31)
		else
			(gEgo sel_110: sel_153: 96 161 sel_585: 732)
		)
		(self
			sel_408:
				(if ((Inv sel_64: 15) sel_4?)
					(if (== gGSel_40 520) 735 else 730)
				else
					780
				)
		)
		(if ((Inv sel_64: 15) sel_4?)
			(Palette palSET_INTENSITY 0 255 0)
		)
		(gGame sel_587:)
		(super sel_110:)
		(if ((Inv sel_64: 15) sel_4?)
			(WrapMusic sel_168: 0)
			(= local0 1)
			(if (== gGSel_40 520)
				(self sel_146: sEnterSouthLight520)
			else
				(self sel_146: sEnterSouthLight)
			)
		else
			(gGameMusic2 sel_40: 56 sel_99: 1 sel_3: -1 sel_39:)
			(gEgo sel_102:)
			(proc958_0 132 82 53)
			(self sel_146: sEnterDark)
		)
	)
	
	(method (sel_57)
		(super sel_57: &rest)
		(if
			(and
				(== (self sel_408?) 780)
				((Inv sel_64: 15) sel_4?)
			)
			(gGame sel_587:)
			(gGameMusic2 sel_170:)
			(WrapMusic sel_168: 0)
			(= local0 1)
			(Palette palSET_INTENSITY 0 255 0)
			(if (== gGSel_40 520)
				(self sel_408: 735 sel_417: 735)
			else
				(self sel_408: 730 sel_417: 730)
			)
			(if (== gGSel_40 520)
				(gEgo
					sel_2: 732
					sel_155: 5
					sel_153: 277 55
					sel_244: 4
					sel_53: 4
					sel_51: 2
					sel_161: Walk
					sel_216:
				)
			else
				(gEgo
					sel_2: 732
					sel_155: 0
					sel_153: 96 161
					sel_244: 4
					sel_53: 4
					sel_51: 2
					sel_161: Walk
					sel_216:
				)
			)
			(= local3 1)
		)
		(if local0
			(Palette palSET_INTENSITY 0 255 (= local2 (+ local2 2)))
			(if (>= local2 100)
				(= local0 0)
				(if local3
					(if (== gGSel_40 520)
						(self sel_146: sEnterSouthLight520)
					else
						(self sel_146: sEnterSouthLight)
					)
				)
			)
		)
		(if local1
			(Palette
				palSET_INTENSITY
				0
				255
				(proc999_3 0 (= local2 (- local2 3)))
			)
			(if (== local2 0) (= local1 0))
		)
	)
	
	(method (sel_111)
		(WrapMusic sel_168: 1)
		(gGameMusic2 sel_170:)
		(super sel_111: &rest)
	)
	
	(method (sel_399 param1)
		(cond 
			((== param1 99) 0)
			((== gGSel_40 650)
				(if
					(and
						(== global123 3)
						(proc0_10 -15612 1)
						(not (proc0_10 -15612))
					)
					(= param1 565)
				else
					(= param1 560)
				)
			)
			((== gGSel_40 630) (= param1 454))
			((== gGSel_40 520) (= param1 610))
		)
		(super sel_399: param1)
	)
)

(instance sEnterSouthLight of Script
	(properties
		sel_20 {sEnterSouthLight}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(if local3
					(= sel_136 1)
				else
					(gEgo
						sel_155: 0
						sel_153: -10 240
						sel_349: 0
						sel_161: Walk
						sel_244: 4
						sel_53: 4
						sel_51: 2
						sel_312: MoveTo 96 161 self
					)
				)
			)
			(1
				(gEgo sel_312: MoveTo 277 55 self)
			)
			(2
				(= local1 1)
				(gEgo sel_312: MoveTo 335 23 self)
			)
			(3
				(global2 sel_417: 780)
				(global2 sel_399: 0)
				(self sel_111:)
			)
		)
	)
)

(instance sEnterSouthLight520 of Script
	(properties
		sel_20 {sEnterSouthLight520}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(if local3
					(= sel_136 1)
				else
					(gEgo
						sel_155: 5
						sel_153: 335 23
						sel_349: 0
						sel_161: Walk
						sel_244: 4
						sel_53: 4
						sel_51: 2
						sel_312: MoveTo 277 55 self
					)
				)
			)
			(1
				(gEgo sel_312: MoveTo 96 161 self)
			)
			(2
				(= local1 1)
				(gEgo sel_312: MoveTo -10 240 self)
			)
			(3
				(global2 sel_417: 780)
				(global2 sel_399: 0)
				(self sel_111:)
			)
		)
	)
)

(instance sEnterDark of Script
	(properties
		sel_20 {sEnterDark}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(if (gEgo sel_238: 15)
					(gGame sel_588:)
					(User sel_237: 0)
					(User sel_347: 0)
					(gIconBar sel_233: 0 1 2 3 4 5 7)
					(= sel_137 8)
				else
					(gIconBar sel_233: 6)
					(= sel_137 4)
				)
			)
			(1
				(sFX2 sel_40: 53 sel_3: -1 sel_99: 1 sel_39:)
				(= sel_139 120)
			)
			(2
				(sFX sel_40: 82 sel_3: 1 sel_99: 5 sel_39: self)
			)
			(3 (sFX2 sel_170: self))
			(4
				(= global145 15)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance sFX of Sound
	(properties
		sel_20 {sFX}
		sel_99 1
	)
)

(instance sFX2 of Sound
	(properties
		sel_20 {sFX2}
		sel_99 1
	)
)
